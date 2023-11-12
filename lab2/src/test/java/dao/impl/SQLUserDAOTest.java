package dao.impl;

import dao.DAOException;
import dao.DAOFactory;
import dao.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class SQLUserDAOTest {
    static UserDAO dao;
    @BeforeAll
    static void init() {
        DAOFactory factory = DAOFactory.getInstance();
        dao = factory.getUserDAO();
    }

    @Test
    void adminSignIn() throws DAOException {
        String login = "admin";
        String password = "admin";
        dao.signIn(login, password);

        assertTrue(true);
    }
}