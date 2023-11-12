package dao;

import beans.User;

public interface UserDAO {
    User signIn(String login, String password) throws DAOException;
    boolean registration(User user) throws DAOException;
}
