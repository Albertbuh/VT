package services.impl;

import beans.Lot;
import beans.Trade;
import beans.TradeRequest;
import beans.User;
import dao.DAOException;
import dao.DAOFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.FileManager;
import services.ServiceException;
import services.TradeService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
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
        List<TradeRequest> result = null;
        try {
            result = tradeDAO.getRequests();
            Collections.sort(result, new Comparator<TradeRequest>() {
                @Override
                public int compare(TradeRequest req1, TradeRequest req2) {
                    return req1.getStatus().compareTo(req2.getStatus());
                }
            });
            return result;
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

    @Override
    public List<Trade> getTrades() throws ServiceException {
        List<Trade> result = null;
        try {
            result = tradeDAO.getTrades();
            for (Trade trade : result) {
                var lot = trade.getRequestInformation().getLot();
                String filename = lot.getDescriptionPath();
                String innerDesc = FileManager.readLotDescription(filename);
                lot.setDescriptionPath(innerDesc);

                lot.setImageName(Lot.defaultImgDir + lot.getImageName());
            }
        }
        catch(Exception e) {
            logger.error("getRequests: {}", e.getMessage());
            return null;
        }
        return result;
    }

    @Override
    public void updateBid(int tradeId, double bidUp, String userLogin) {
        try {
            if(tradeId > 0 && bidUp > 0) {
                tradeDAO.updateBid(tradeId, bidUp, userLogin);
            }
        } catch (DAOException e) {
            logger.error(e.getMessage());
        }
    }
}
