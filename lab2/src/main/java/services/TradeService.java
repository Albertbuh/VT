package services;

import beans.Lot;
import beans.Trade;
import beans.TradeRequest;
import beans.User;

import java.sql.SQLException;
import java.util.List;

public interface TradeService {
    TradeRequest makeRequest(User user, Lot lot, int period);
    List<TradeRequest> getRequests();

    void processTradeRequest(TradeRequest request, User admin, boolean accept);
}
