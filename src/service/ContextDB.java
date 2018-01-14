package service;

import DAO.UsersDAO;
import domain.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.security.EncryptedPass;

import java.sql.SQLException;

public class ContextDB {
    private static final Logger logger = LogManager.getLogger(ContextDB.class.getName());

    /**
     * Поиск пользователя в базе данных
     *
     * @param userDAO - пользователь из БД
     * @param login - пользовательский логин, который считывается с входных аргументов
     * @return - true, если пользователь найден
     */
    boolean searchUserInDB(UsersDAO userDAO, String login) throws SQLException {
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
    boolean validHashPassword(UsersDAO userDAO, String login, String password) throws SQLException {
        Users user = userDAO.searchUser(login);
        String hashPassword = EncryptedPass.setPasswordHash(password, user.getSalt());
        if (user.getPassword().equals(hashPassword)) {
            return true;
        }

        logger.error("Хэши не совпадают!");
        return false;
    }
}
