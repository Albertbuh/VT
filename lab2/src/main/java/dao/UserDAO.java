package dao;

import beans.User;

public interface UserDAO {
    User signIn(String login, String password);
    boolean registration(User user);
}
