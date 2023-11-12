package services.impl;

import beans.User;
import dao.DAOFactory;
import dao.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.ClientService;
import services.ServiceException;
import services.ServiceFactory;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImplTest {

    static ClientService service;
    @BeforeAll
    static void init() {
        ServiceFactory factory = ServiceFactory.getInstance();
        service = factory.getClientService();
    }

    @Test
    void adminSignIn() throws ServiceException {
        String login = "admin";
        String password = "admin";
        User u = service.signIn(login, password);
        User expectedU = new User(login, DigestUtils.md5Hex(password).toUpperCase(), "ADMIN");
        assertEquals(u, expectedU);
    }

    @Test
    void emptyAdminSignIn() throws ServiceException {
        String login = "admin";
        String password = "";
        service.signIn(login, password);
        assertTrue(true);
    }

    @Test
    void registration() throws ServiceException {
        String login = "Test" + java.util.UUID.randomUUID();
        String password = "test";
        var user = service.registration(login, password);
        assertEquals(user.getLogin(), login.toLowerCase());
    }

    @Test
    void checkRegistrationOfUserWhichAlreadyInDatabase() throws ServiceException {
        String login = "admin";
        String password = "admin";
        var user = service.registration(login, password);
        assertTrue(user.getLogin().isEmpty());
    }
}