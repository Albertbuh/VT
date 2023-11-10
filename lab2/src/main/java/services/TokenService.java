package services;

import beans.User;

public interface TokenService {
    String create(User user);
    String getSecret(String token);
}
