package Library_classes;

import Security.EncryptedPass;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Users {
    private String login;
    private String password;
    private String salt;

    private static String setSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        return Arrays.toString(bytes);
    }

    public Users(String login, String password) throws NoSuchAlgorithmException {
        this.login = login;
        this.salt = setSalt();
        this.password = EncryptedPass.hashPassword(password, salt);
    }

    String getLogin() {
        return this.login;
    }

    String getPassword() {
        return this.password;
    }

    String getSalt() {
        return this.salt;
    }

    void setSalt(String salt) {
        this.salt = salt;
    }

    void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = EncryptedPass.hashPassword(password, salt);
    }
}
