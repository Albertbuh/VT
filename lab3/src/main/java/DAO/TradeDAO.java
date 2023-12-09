package org.education.DAO;

import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.Trade;

import java.util.List;
import java.util.Optional;

public interface TradeDAO {    
    List<Trade> getTrades() throws DatabaseQueryException;
    Optional<Trade> getTradeByName(String name) throws DatabaseQueryException;
    Optional<Trade> getTradeById(int id) throws DatabaseQueryException;
}
