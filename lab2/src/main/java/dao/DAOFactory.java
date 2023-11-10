package dao;

import dao.impl.SQLTradeDAO;
import dao.impl.SQLUserDAO;

public final class DAOFactory {
    private static final DAOFactory factory = new DAOFactory();
    private final UserDAO userDAOImpl = new SQLUserDAO();
    private final TradeDAO tradeDAOImpl = new SQLTradeDAO();
    public static DAOFactory getInstance() {
        return factory;
    }

    public UserDAO getUserDAO() {
        return userDAOImpl;
    }
    public TradeDAO getTradeDAO() { return tradeDAOImpl;  }
}
