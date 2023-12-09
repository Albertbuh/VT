package org.education.service;

import org.education.beans.User;
import org.education.service.exception.AlreadyExistException;
import org.education.service.exception.ServiceException;
import org.education.service.exception.UnknownUserException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers() throws ServiceException;
    Optional<User> getUserByUsername(String name) throws ServiceException;
    Optional<User> getUserById(int id) throws ServiceException;
    void newUser(String email, String password, String username) throws ServiceException;
    void deleteUser(int id) throws ServiceException;
    void changeStatus(int id) throws ServiceException;
}
