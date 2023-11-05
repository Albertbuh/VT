package beans;

public class User {
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

}
