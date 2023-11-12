package dao.impl;

import beans.*;
import dal.ConnectionPool;
import dal.ConnectionPoolFactory;
import dao.DAOException;
import dao.TradeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SQLTradeDAO implements TradeDAO {

    private ConnectionPool connectionPool;
    private final Logger logger = LoggerFactory.getLogger("SQLTradeDAO");
    public SQLTradeDAO(){
        try {
            connectionPool = ConnectionPoolFactory.getMysqlPool();
        }
        catch (SQLException | ClassNotFoundException e) {
            logger.error("Constructor: {}", e.getMessage());
//            throw new DAOException(e);
        }
    }



    public int getObjectId(Connection con,  String tableName, String idColumn, String nameColumn, String name) throws DAOException{
        String sql = "SELECT " + idColumn +
                     " FROM " + tableName +
                     " WHERE " + nameColumn + " = \"" + name + "\"";
        Statement st = null;
        ResultSet rs = null;
        int id = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("getObjectId: {}", e.getMessage());
        }
        finally {
            try {
                if(st != null) {st.close(); }
                if(rs != null) {rs.close(); }
            } catch (SQLException e) {
                logger.error("unable to clear resources in getObjectId: {}", e.getMessage());
            }
        }

        return id;
    }

    @Override
    public boolean makeRequest(TradeRequest request) throws DAOException{
        boolean result = true;
        String sqlInsert = "INSERT INTO " +
                "trade_requests (`tr_user_id`, `tr_period`, `tr_filling_date`, " +
                "`tr_lot_name`, `tr_lot_desc_path`, `tr_lot_img_path`, `tr_lot_price`) " +
                "values(?, ?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = connectionPool.getConnection();
            ps = con.prepareStatement(sqlInsert);
            int uId = getObjectId(con, "users", "u_id", "u_login", request.getUser().getLogin());
            ps.setInt(1, uId);
            ps.setInt(2, request.getPeriod());
            ps.setDate(3, Date.valueOf(request.getFillingDate()));
            ps.setString(4, request.getLot().getName());
            ps.setString(5, request.getLot().getDescriptionPath());
            ps.setString(6, request.getLot().getImageName());
            ps.setBigDecimal(7, request.getLot().getPrice());

            ps.executeUpdate();
        } catch (SQLException | DAOException e) {
            System.out.println(e.getMessage());
            result = false;
        }
        finally {
            try {
                if(ps != null) {ps.close();}
                if(con != null) {connectionPool.releaseConnection(con);}
            } catch (SQLException e) {
                logger.error("makeRequest: {}", e.getMessage());
                result = false;
            }
        }
        return result;
    }



    @Override
    public void acceptRequest(int requestId, User admin) throws DAOException {
        String sqlUpdate = "UPDATE trade_requests SET `tr_status` = 'ACCEPTED' WHERE tr_id = " + requestId;
        String sqlCreateTrade = "INSERT INTO trades (`t_request_id`, `t_admin_login`, `t_start_date`, `t_status`, `t_max_bid`, `t_max_bid_user_login`)" +
                "VALUES (?,?,?, 'IN_PROCESS', (SELECT `tr_lot_price` FROM  trade_requests WHERE `tr_id` = `t_request_id`), null)";
        Connection con = null;
        Statement stUpdate = null;
        PreparedStatement ps = null;
        try {
            con = connectionPool.getConnection();
            con.setAutoCommit(false);

            stUpdate = con.createStatement();
            stUpdate.executeUpdate(sqlUpdate);

            ps = con.prepareStatement(sqlCreateTrade);
            ps.setInt(1,requestId);
            ps.setString(2, admin.getLogin());
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            ps.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            logger.error("acceptRequest: {}", e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                logger.error("unsuccessfull rollback: {}", e.getMessage());
            }
        }
        finally {
            try {
                if(con != null) {connectionPool.releaseConnection(con); }
                if(stUpdate != null) { stUpdate.close();}
                if(ps != null) {ps.close();}
            } catch (SQLException e) {
                logger.error("acceptRequest: {}", e.getMessage());
            }
        }
    }

    @Override
    public void rejectRequest(int id) throws DAOException {
        String sql = "UPDATE trade_requests SET `tr_status` = 'REJECTED' WHERE tr_id = " + id;
        Connection con = null;
        Statement st = null;
        try {
            con = connectionPool.getConnection();
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            logger.error("rejectRequest: {}", e.getMessage());
        }
        finally {
            try {
                if(con != null) {connectionPool.releaseConnection(con);}
                if(st != null) {st.close();}
            } catch (SQLException e) {
                logger.error("rejectRequest: {}", e.getMessage());
            }
        }
    }
    @Override
    public List<TradeRequest> getRequests() throws DAOException{
        List<TradeRequest> resultList = new ArrayList<>();
        String sql = "SELECT `tr_lot_name`, `tr_lot_desc_path`, `tr_lot_img_path`, `tr_lot_price`, " +
                "`tr_period`, `tr_filling_date`, `tr_status`, `u_login`, `tr_id` " +
                "FROM trade_requests " +
                "LEFT JOIN users on `u_id` = `tr_user_id`";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = connectionPool.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                String lotName = rs.getString(1);
                String lotDesc = rs.getString(2);
                String lotImg = rs.getString(3);
                double lotPrice = rs.getDouble(4);
                int tradePeriod = rs.getInt(5);
                LocalDate date = rs.getDate(6).toLocalDate();
                TradeStatus status = TradeStatus.valueOf(rs.getString(7));
                String userLogin = rs.getString(8);
                int id = rs.getInt(9);

                Lot l = new Lot(lotName, lotDesc, lotImg, lotPrice);
                User u = new User(userLogin, "", "");
                TradeRequest tr = new TradeRequest(id, u, l, tradePeriod);
                tr.setFillingDate(date);
                tr.setStatus(status);

                resultList.add(tr);
            }
        }
        catch(SQLException e) {
            logger.error("getRequests: {}", e.getMessage());
        }
        finally {
            try {
                if(con != null) { connectionPool.releaseConnection(con);}
                if(st != null) {st.close();}
                if(rs != null) {rs.close();}
            } catch (SQLException e) {
                logger.error("getRequests: {}", e.getMessage());
            }
        }
        return resultList;
    }

    @Override
    public List<Trade> getTrades() throws DAOException {
        List<Trade> tradeList = new ArrayList<>();
        String sql = "SELECT `tr_lot_name`, `tr_lot_desc_path`, `tr_lot_img_path`, " +
                        "`t_max_bid`, `tr_period`, `t_status`, `t_start_date` " +
                        "FROM trades LEFT JOIN trade_requests ON `t_request_id` = `tr_id`";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = connectionPool.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()) {
                String lotName = rs.getString(1);
                String lotDescPath = rs.getString(2);
                String lotImgPath = rs.getString(3);
                double lotMaxBid = rs.getDouble(4);
                int period = rs.getInt(5);
                TradeStatus status = TradeStatus.valueOf(rs.getString(6));
                LocalDateTime startDate = rs.getTimestamp(7).toLocalDateTime();
                TradeRequest mockRequest = new TradeRequest(new User(), new Lot(lotName, lotDescPath, lotImgPath, lotMaxBid), period);
                Trade trade = new Trade(mockRequest, status, startDate);

                tradeList.add(trade);
            }
        }
        catch (SQLException e) {
            logger.error("getTrades: {}", e.getMessage());
        }
        finally {
            try {
                if(con != null) { connectionPool.releaseConnection(con); }
                if(st != null) {st.close();}
                if(rs != null) {rs.close();}
            } catch (SQLException e) {
                logger.error("getTrades: {}", e.getMessage());
            }
        }

        return tradeList;
    }
}
