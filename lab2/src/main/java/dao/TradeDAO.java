package dao;

import beans.Lot;
import beans.Trade;
import beans.TradeRequest;
import beans.User;

import java.math.BigDecimal;
import java.util.List;

public interface TradeDAO {
    void createLot(Lot lot);
    boolean makeRequest(TradeRequest request);
    void acceptRequest(TradeRequest request, User admin);
    void rejectRequest(int id);
    List<TradeRequest> getRequests();
}
