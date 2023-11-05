package dal;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCConnectionPoolTest {

    @Test
    void checkCorrectJDBCConnection() throws SQLException, ClassNotFoundException {
        ConnectionPool connectionPool = JDBCConnectionPool.create("jdbc:mysql://127.0.0.1/auction",
                "root", "root");

        assertTrue(connectionPool.getConnection().isValid(1));
    }
}