package service;

import DAO.UsersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        ContextDB contextDB = new ContextDB();
        if (!contextDB.searchUserInDB(userDAO, login)) {
            logger.error("Пользователь не найден");
            System.exit(1);
        }

        if (!contextDB.validHashPassword(userDAO, login, password)) {
            logger.error("Неверный пароль");
            System.exit(2);
        }
        return true;
    }
}