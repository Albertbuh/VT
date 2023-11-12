package services.impl;

import beans.Lot;
import beans.TradeRequest;
import beans.User;
import dao.DAOFactory;
import services.TradeService;

import java.sql.SQLException;
import java.util.List;

public class TradeServiceImpl implements TradeService {

    dao.TradeDAO tradeDAO = DAOFactory.getInstance().getTradeDAO();

    @Override
    public TradeRequest makeRequest(User user, Lot lot, int period) {
        var tradeRequest = new TradeRequest(user, lot, period);

        if(tradeDAO.makeRequest(tradeRequest))
            return tradeRequest;
        else {
            System.out.println("SOMETHING WRONG IN TRADE SERVICE");
            return null;
        }

    }

    @Override
    public List<TradeRequest> getRequests() {
        try {
            return tradeDAO.getRequests();
        }
        catch(Exception e) {
            return null;
        }
    }

    @Override
    public void processTradeRequest(int requestId, User admin, boolean accept) {
        if(accept) {
            tradeDAO.acceptRequest(requestId, admin);
        }
        else {
            tradeDAO.rejectRequest(requestId);
        }
    }
}
