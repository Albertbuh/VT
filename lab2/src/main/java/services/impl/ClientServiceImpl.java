package services.impl;

import beans.User;
import controllers.JspDispatcher;
import dao.DAOFactory;
import dao.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;
import services.ClientService;

public class ClientServiceImpl implements ClientService {

    private String MD5Hash(String password) {
        return DigestUtils.md5Hex(password).toUpperCase();
    }

    @Override
    public User signIn(String login, String password) {
        if(login.isEmpty() || password.isEmpty())
            return new User();

        login = login.trim().toLowerCase();
        password = MD5Hash(password.trim());

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO dao = factory.getUserDAO();
        return dao.signIn(login, password);
    }

    @Override
    public void signOut(String login) {

    }

    @Override
    public User registration(String login, String password) {
        if(login.isEmpty() || password.isEmpty())
            return new User();

        login = login.trim().toLowerCase();
        password = MD5Hash(password.trim());

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO dao = factory.getUserDAO();
        User newUser = new User(login, password, "USER");
        if(dao.registration(newUser))
            return newUser;
        else
            return new User();
    }
}
