package org.education.service;

import org.education.beans.Movie;
import org.education.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;


public interface TradeService {
    List<Movie> getTrades() throws ServiceException;
    Optional<Movie> getTradeById(int id);
    Optional<Movie> getTradeRequestById(int id) throws ServiceException;
}
