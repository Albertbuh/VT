package dao;

import beans.Lot;
import beans.Trade;
import beans.TradeRequest;
import beans.User;

import java.math.BigDecimal;
import java.util.List;

public interface TradeDAO {
    boolean makeRequest(TradeRequest request) throws DAOException;
    void acceptRequest(int id, User admin) throws DAOException;
    void rejectRequest(int id) throws DAOException;
    List<TradeRequest> getRequests() throws DAOException;
    List<Trade> getTrades() throws DAOException;
}
