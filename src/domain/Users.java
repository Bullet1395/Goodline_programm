package domain;

import service.security.EncryptedPass;
import java.security.NoSuchAlgorithmException;

public class Users {
    private String login;
    private String password;
    private String salt;

    public Users(String login, String password) {
        this.login = login;
        this.salt = EncryptedPass.setSalt();
        this.password = EncryptedPass.hashPassword(password, salt);
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

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = EncryptedPass.hashPassword(password, salt);
    }
}
