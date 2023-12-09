package org.education.DAO.impl;

import org.education.DAO.TradeDAO;
import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.Trade;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TradeDAOImpl implements TradeDAO {

    private  final SessionFactory sessionFactory;

    @Autowired
    public TradeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Trade> getTrades() throws DatabaseQueryException{
        return sessionFactory.fromTransaction(session -> session.createSelectionQuery("from Trade", Trade.class).getResultList());
    }

    @Override
    public Optional<Trade> getTradeByName(String name) throws DatabaseQueryException {
        return sessionFactory.fromTransaction(session -> {
            var query = session.createSelectionQuery("from Trade where name = :name", Trade.class);
            query.setParameter("name",name);
            Trade trade = query.getSingleResultOrNull();
            if (trade == null) return Optional.empty();
            else return Optional.of(trade);
        });
    }

    @Override
    public Optional<Trade> getTradeById(int id) throws DatabaseQueryException {
        return sessionFactory.fromTransaction(session -> {
            var query = session.createSelectionQuery("from Trade where id = :id", Trade.class);
            query.setParameter("id",id);
            Trade trade = query.getSingleResultOrNull();
            if (trade == null) return Optional.empty();
            else return Optional.of(trade);
        });
    }

    @Override
    public void updateTradeMark(Trade trade) throws DatabaseQueryException {
        sessionFactory.inTransaction(session -> session.merge(trade));
    }
}
