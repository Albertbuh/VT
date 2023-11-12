package services;

import beans.User;

public interface ClientService {
    User signIn(String login, String password) throws ServiceException;
    void signOut(String login) throws ServiceException;
    User registration(String login, String password) throws ServiceException;
}
