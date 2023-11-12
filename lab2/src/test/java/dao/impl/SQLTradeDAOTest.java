package dao.impl;

import beans.Lot;
import beans.TradeRequest;
import beans.User;
import dal.ConnectionPoolFactory;
import dao.DAOFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SQLTradeDAOTest {

    SQLTradeDAO dao = (SQLTradeDAO)DAOFactory.getInstance().getTradeDAO();
    @Test
    void createLot() {
        Lot lot = new Lot("test", "", "", 1000);
        try {
            dao.createLot(lot);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
        assertTrue(true);
    }

    @Test
    void getUserId() throws SQLException, ClassNotFoundException {
        Connection con = null;
        int id = 0;
        try {
            con = ConnectionPoolFactory.getMysqlPool().getConnection();
            id = dao.getObjectId(con, "users", "u_id", "u_login", "admin");
        }
        finally {
            if(con != null) {ConnectionPoolFactory.getMysqlPool().releaseConnection(con);}
        }
        assertEquals(1, id);
    }

    @Test
    void getLotId() throws SQLException, ClassNotFoundException {
        Connection con = null;
        int id = 0;
        try {
            con = ConnectionPoolFactory.getMysqlPool().getConnection();
            id = dao.getObjectId(con, "lots", "l_id", "l_name", "test.7e813b75-a04d-4a13-8c16-6cd6740fdbb3");
        }
        finally {
            if(con != null) {ConnectionPoolFactory.getMysqlPool().releaseConnection(con);}
        }
        assertEquals(3, id);
    }

    @Test
    void makeRequest() {
        boolean result = false;

        User u = new User("perry", "", "USER");
        Lot l = new Lot();
        l.setPrice(new BigDecimal(23.32));
        l.setName("test");
        TradeRequest req = new TradeRequest(u, l, 10);
        try {
            result = dao.makeRequest(req);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertTrue(result);
    }

    @Test
    void getRequests() {
        var list = dao.getRequests();
        for(var tr: list) {
            System.out.println(tr.toString());
        }
        assertFalse(list.isEmpty());
    }

    @Test
    void acceptRequest() {
        var request = new TradeRequest(9);
        var admin  = new User("admin", "", "ADMIN");
        dao.acceptRequest(request, admin);
        assertTrue(true);
    }

    @Test
    void rejectRequest() {
        dao.rejectRequest(9);
        assertTrue(true);
    }
}