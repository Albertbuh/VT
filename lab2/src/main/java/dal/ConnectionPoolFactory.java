package dal;

import java.sql.SQLException;

public class ConnectionPoolFactory {
    public static ConnectionPool getMysqlPool() throws SQLException, ClassNotFoundException {
        return JDBCConnectionPool.create("jdbc:mysql://127.0.0.1/auction",
                "root", "root");
    }
}
