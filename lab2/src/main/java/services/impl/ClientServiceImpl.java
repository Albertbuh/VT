package services.impl;

import beans.User;
import controllers.JspDispatcher;
import dao.DAOException;
import dao.DAOFactory;
import dao.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.ClientService;
import services.ServiceException;

public class ClientServiceImpl implements ClientService {

    private final Logger logger = LoggerFactory.getLogger("ClientServiceImpl");
    private String MD5Hash(String password) {
        return DigestUtils.md5Hex(password).toUpperCase();
    }

    @Override
    public User signIn(String login, String password) throws ServiceException{
        if(login.isEmpty() || password.isEmpty())
            return new User();

        login = login.trim().toLowerCase();
        password = MD5Hash(password.trim());

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO dao = factory.getUserDAO();
        User result = null;
        try {
            result = dao.signIn(login, password);
            logger.info("user {} has been signed in", login);
        } catch (DAOException e) {
            logger.error("signIn: {}", e.getMessage());
        }
        return result;
    }

    @Override
    public void signOut(String login) throws ServiceException{

    }

    @Override
    public User registration(String login, String password) throws ServiceException {
        if(login.isEmpty() || password.isEmpty())
            return new User();

        login = login.trim().toLowerCase();
        password = MD5Hash(password.trim());

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO dao = factory.getUserDAO();
        User newUser = new User(login, password, "USER");
        boolean registered = false;
        try {
            registered = dao.registration(newUser);
            logger.info("user {} has been registered", login);
        } catch (DAOException e) {
            logger.error("registration: {}", e.getMessage());
        }
        return registered ? newUser : new User();
    }
}
