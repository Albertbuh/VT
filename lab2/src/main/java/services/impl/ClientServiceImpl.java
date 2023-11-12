package services.impl;

import beans.User;
import controllers.JspDispatcher;
import dao.DAOException;
import dao.DAOFactory;
import dao.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;
import services.ClientService;
import services.ServiceException;

public class ClientServiceImpl implements ClientService {

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
        } catch (DAOException e) {
            System.out.println(e.getMessage());
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
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
        return registered ? newUser : new User();
    }
}
