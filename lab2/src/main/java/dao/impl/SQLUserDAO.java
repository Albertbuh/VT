package dao.impl;

import beans.User;
import dal.ConnectionPool;
import dal.ConnectionPoolFactory;
import dal.JDBCConnectionPool;
import dao.DAOException;
import dao.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

public class SQLUserDAO implements UserDAO {
    private ConnectionPool connectionPool;

    public SQLUserDAO() {
        try {
            connectionPool = ConnectionPoolFactory.getMysqlPool();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean registration(User user) throws DAOException {
        String sqlInsertUser = "INSERT INTO users VALUES (null, ?, ?, 'USER')";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = connectionPool.getConnection();
            ps = conn.prepareStatement(sqlInsertUser);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            try {
                if(ps != null) {ps.close(); }
                if(conn != null) { connectionPool.releaseConnection(conn); }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }
    @Override
    public User signIn(String login, String password) throws DAOException{
        String sqlGetUser = "SELECT u_login, u_password, u_role FROM users where u_login = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User result = new User();
        try {
             conn = connectionPool.getConnection();
             ps = conn.prepareStatement(sqlGetUser);
             ps.setString(1, login);
             rs = ps.executeQuery();

             if(rs.next()) {
                 String passwordConfirm = rs.getString(2);

                 if(passwordConfirm.equalsIgnoreCase(password))
                     result = new User(rs.getString(1), rs.getString(2), rs.getString(3));
             }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(rs != null) { rs.close(); }
                if(ps != null) {ps.close(); }
                if(conn != null) { connectionPool.releaseConnection(conn); }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
    }
}
