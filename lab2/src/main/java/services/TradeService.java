package services;

import beans.Lot;
import beans.Trade;
import beans.TradeRequest;
import beans.User;

import java.sql.SQLException;
import java.util.List;

public interface TradeService {
    TradeRequest makeRequest(User user, Lot lot, int period) throws ServiceException;
    List<TradeRequest> getRequests() throws ServiceException;

    void processTradeRequest(int requestId, User admin, boolean accept) throws ServiceException;
}
