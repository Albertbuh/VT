package beans;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 2L;
    private String login;
    private String password;
    private String role;

    public User() {
        login = "";
        password = "";
        role = "USER";
    }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public void SetRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User u) {
            return this.password.equalsIgnoreCase(u.password)
                    && this.login.equalsIgnoreCase(u.login);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return  (7 * password.hashCode()
                + 2 * login.hashCode())
                % Integer.MAX_VALUE;
    }

}
