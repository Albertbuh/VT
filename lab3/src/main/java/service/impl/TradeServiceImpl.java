package org.education.service.impl;

import org.education.DAO.AuctionDAO;
import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.Auction;
import org.education.service.AuctionService;
import org.education.service.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TradeServiceImpl implements AuctionService {

    private final AuctionDAO dao;

    public AuctionServiceImpl(AuctionDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Trade> getTrades(int pageInd) throws ServiceException {
        try{
            res = dao.getTrades();
        }
        catch (DatabaseQueryException e) {
            throw new ServiceException(e.getMessage());
        }
        return res;
    }

    @Override
    public Optional<Trade> getTradeByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Trade> getTradeById(int id) throws ServiceException {
        try{
            return dao.getTradeById(id);
        } catch (DatabaseQueryException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
