package dao;

import beans.User;

public interface UserDAO {
    void SignIn(String login, String password);
}
