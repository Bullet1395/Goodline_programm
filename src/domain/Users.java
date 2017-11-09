package domain;

import service.security.EncryptedPass;

public class Users {
    private String login;
    private String password;
    private String salt;

    public Users(String login, String password, String salt) {
        this.login = login;
        this.salt = salt;
        this.password = EncryptedPass.setPasswordHash(password, salt);
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

    /**
     * Позволяет задавать salt через параметр
     *
     * @param salt salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }
}
