package services.impl;

import beans.Lot;
import beans.TradeRequest;
import beans.User;
import dao.DAOFactory;
import services.TradeService;

import java.sql.SQLException;

public class TradeServiceImpl implements TradeService {
    @Override
    public TradeRequest makeRequest(User user, Lot lot, int period) {
        var tradeRequest = new TradeRequest(user, lot, period);

        var factory = DAOFactory.getInstance();
        var tradeService = factory.getTradeDAO();
        if(tradeService.makeRequest(tradeRequest))
            return tradeRequest;
        else {
            System.out.println("SOMETHING WRONG IN TRADE SERVICE");
            return null;
        }

    }
}
