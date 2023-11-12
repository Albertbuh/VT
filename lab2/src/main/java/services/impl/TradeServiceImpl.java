package services.impl;

import beans.Lot;
import beans.TradeRequest;
import beans.User;
import dao.DAOException;
import dao.DAOFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.ServiceException;
import services.TradeService;

import java.sql.SQLException;
import java.util.List;

public class TradeServiceImpl implements TradeService {

    private final dao.TradeDAO tradeDAO = DAOFactory.getInstance().getTradeDAO();
    private final Logger logger = LoggerFactory.getLogger("TradeServiceImpl");
    @Override
    public TradeRequest makeRequest(User user, Lot lot, int period) throws ServiceException{
        TradeRequest tradeRequest = null;

        try {
            tradeRequest = new TradeRequest(user, lot, period);
            if(!tradeDAO.makeRequest(tradeRequest)) {
                logger.debug("Something wrong in tradeDAO.makeRequest (return false)");
                tradeRequest = null;
            }
        } catch (DAOException e) {
            logger.error("makeRequest error: {}", e.getMessage());
        }
        return tradeRequest;
    }

    @Override
    public List<TradeRequest> getRequests() throws ServiceException{
        try {
            return tradeDAO.getRequests();
        }
        catch(Exception e) {
            logger.error("getRequests: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void processTradeRequest(int requestId, User admin, boolean accept) throws ServiceException{
        try {
            if(accept) {
                tradeDAO.acceptRequest(requestId, admin);
            }
            else {
                tradeDAO.rejectRequest(requestId);
            }
        } catch (DAOException e) {
            logger.error("processTradeRequest: {}", e.getMessage());
        }
    }
}
