package services;

import beans.User;

public interface ClientService {
    User signIn(String login, String password);
    void signOut(String login);
    User registration(String login, String password);
}
