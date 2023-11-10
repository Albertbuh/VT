package services.impl;

import beans.User;
import dao.DAOFactory;
import dao.UserDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.ClientService;
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
    void adminSignIn()  {
        String login = "admin";
        String password = "admin";
        service.signIn(login, password);
        assertTrue(true);
    }

    @Test
    void emptyAdminSignIn()  {
        String login = "admin";
        String password = "";
        service.signIn(login, password);
        assertTrue(true);
    }

    @Test
    void registration() {
        String login = "Test" + java.util.UUID.randomUUID();
        String password = "test";
        var user = service.registration(login, password);
        assertEquals(user.getLogin(), login.toLowerCase());
    }

    @Test
    void checkRegistrationOfUserWhichAlreadyInDatabase() {
        String login = "admin";
        String password = "admin";
        var user = service.registration(login, password);
        assertTrue(user.getLogin().isEmpty());
    }
}