package services;

import beans.User;

public interface TokenService {
    String create(User user) throws ServiceException;
    String getSecret(String token) throws ServiceException;
}
