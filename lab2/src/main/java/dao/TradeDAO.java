package dao;

import beans.Lot;
import beans.Trade;
import beans.TradeRequest;

import java.math.BigDecimal;

public interface TradeDAO {
    void createLot(Lot lot);
    boolean makeRequest(TradeRequest request);
    Trade acceptRequest(int id);
}
