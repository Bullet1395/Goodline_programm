package domain;

import service.security.EncryptedPass;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

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

    /**
     * ПОзволяет задавать salt через параметр
     *
     * @param salt salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * Генерирует случайное значение salt и возвращает его
     *
     * @return массив байтов
     */
    public static String setSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        return Arrays.toString(bytes);
    }

    /**
     * Задает пароль и сохраняет его в hash виде
     *
     * @param password пароль
     * @throws NoSuchAlgorithmException;
     */
    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = EncryptedPass.hashPassword(password, salt);
    }
}
