package org.education.DAO.impl;

import org.education.DAO.UserDAO;
import org.education.DAO.exception.DatabaseQueryException;
import org.education.beans.Role;
import org.education.beans.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {

//    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getUsers() throws DatabaseQueryException {
        return sessionFactory.fromTransaction(session -> session.createSelectionQuery("from User", User.class).getResultList());
    }

    @Override
    public Optional<User> getUserByUsername(String name) throws DatabaseQueryException {
        return sessionFactory.fromTransaction(session -> {
            var query = session.createSelectionQuery("from User where username = :name", User.class);
            query.setParameter("name",name);
            User user = query.getSingleResultOrNull();
            if (user == null) return Optional.empty();
            else return Optional.of(user);
        });
    }

    @Override
    public Optional<User> getUserByEmail(String name) throws DatabaseQueryException {
        return sessionFactory.fromTransaction(session -> {
            var query = session.createSelectionQuery("from User where login = :name", User.class);
            query.setParameter("name",name);
            User user = query.getSingleResultOrNull();
            if (user == null) return Optional.empty();
            else return Optional.of(user);
        });
    }

    @Override
    public Optional<User> getUserById(int id) throws DatabaseQueryException {
        return sessionFactory.fromTransaction(session -> {
            var query = session.createSelectionQuery("from User where id = :id", User.class);
            query.setParameter("id",id);
            User user = query.getSingleResultOrNull();
            if (user == null) return Optional.empty();
            else return Optional.of(user);
        });
    }

    @Override
    public void saveUser(User user) throws DatabaseQueryException {
        sessionFactory.inTransaction(session -> session.merge(user));
    }

    @Override
    public void deleteUser(int user_id) throws DatabaseQueryException {
        sessionFactory.inTransaction(session -> {
            User user = session.createSelectionQuery("from User where id = :id", User.class).getSingleResultOrNull();
            if (user != null) session.remove(user);
        });
    }
}
