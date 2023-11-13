package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnectionPool implements ConnectionPool {
    private String url;
    private String user;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static final int DEFAULT_POOL_SIZE = 20;

    public static JDBCConnectionPool create(String url, String user, String password)
            throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        List<Connection> pool = new ArrayList<>(DEFAULT_POOL_SIZE);
        for(int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new JDBCConnectionPool(url, user, password, pool);
    }

    JDBCConnectionPool() {
        this.url = "";
        this.user = "";
        this.password = "";
        this.connectionPool = new ArrayList<>(DEFAULT_POOL_SIZE);
    }
    JDBCConnectionPool(String url, String user, String password, List<Connection> pool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = pool;
    }

    private static Connection createConnection(String url, String user, String password)
        throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
    @Override
    public Connection getConnection() {
        Connection connection = null;
        if(connectionPool.size() > 0) {
            connection = connectionPool.remove(connectionPool.size() - 1);
            usedConnections.add(connection);
        }
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }
    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
