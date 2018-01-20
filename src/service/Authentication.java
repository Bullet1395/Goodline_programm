package service;

import DAO.UsersDAO;
import domain.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.security.EncryptedPass;

import java.sql.SQLException;

public class Authentication {
    private static final Logger logger = LogManager.getLogger(Authentication.class.getName());

    /**
     * Проверка аутентификации пользователя
     *
     * @param userDAO - пользователь из БД
     * @param login - логин полученный из аругментов
     * @param password - пароль полученный из аргументов
     * @return true, если пользователь аутентифицирован
     */
     public boolean isAuthentication(UsersDAO userDAO, String login, String password) throws SQLException {
        if (!searchUserInDB(userDAO, login)) {
            logger.error("Пользователь не найден");
            System.exit(1);
        }

        if (!validHashPassword(userDAO, login, password)) {
            logger.error("Неверный пароль");
            System.exit(2);
        }
        return true;
    }

    /**
     * Поиск пользователя в базе данных
     *
     * @param userDAO - пользователь из БД
     * @param login - пользовательский логин, который считывается с входных аргументов
     * @return - true, если пользователь найден
     */
    private boolean searchUserInDB(UsersDAO userDAO, String login) throws SQLException {
        Users user = userDAO.searchUser(login);
        if (user == null) {
            logger.error("Пользователь не найден");
            return false;
        }
        return true;
    }

    /**
     * Проверка пароля пользователя
     *
     * @param userDAO   - пользователь из БД
     * @param login - пользовательский логин, который считывается с входных аргументов
     * @param password - пользовательская пароль, которая считывается с входных аргументов
     * @return - true, если хэши паролей совпадают
     */
    private boolean validHashPassword(UsersDAO userDAO, String login, String password) throws SQLException {
        Users user = userDAO.searchUser(login);
        String hashPassword = EncryptedPass.setPasswordHash(password, user.getSalt());
        if (user.getPassword().equals(hashPassword)) {
            return true;
        }

        logger.error("Хэши не совпадают!");
        return false;
    }
}