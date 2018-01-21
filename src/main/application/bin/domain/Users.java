package bin.domain;

public class Users {
    private String login;
    private String password;
    private String salt;

    public Users(String login, String password, String salt) {
        this.login = login;
        this.salt = salt;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSalt() {
        return this.salt;
    }
}
