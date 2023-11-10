package dal;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class JDBCConnectionPoolTest {

    @Test
    void checkCorrectJDBCConnection() throws SQLException, ClassNotFoundException {
        ConnectionPool connectionPool = JDBCConnectionPool.create("jdbc:mysql://127.0.0.1/auction",
                "root", "root");

        assertTrue(connectionPool.getConnection().isValid(1));
    }

    @Test
    void getAdminsAccountsFromMysql() throws SQLException, ClassNotFoundException {
        ConnectionPool connectionPool = JDBCConnectionPool.create("jdbc:mysql://127.0.0.1/auction",
                "root", "root");
        var connection = connectionPool.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users WHERE u_role = 'ADMIN'");
        boolean isOk = true;
        int count = 0;
        while (rs.next()) {
            isOk &= rs.getString(4).equals("ADMIN");
            System.out.println(
                    rs.getString(2) + " " +
                    rs.getString(3));
            count++;
        }
        isOk &= count == 2;

        assertTrue(isOk);
    }
}