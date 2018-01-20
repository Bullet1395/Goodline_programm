package main.service;

import main.DAO.ResourceDAO;
import main.domain.Resources;
import main.domain.enums.Roles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Authorization {
    private static final Logger logger = LogManager.getLogger(Authorization.class.getName());

    /**
     * Проверка доступа к ресурсу
     *
     * @param resourceDAO - ресурс из БД
     * @param resource - путь ресурса из аргументов
     * @param role - роль из аругментов
     * @return - true, если доступ к ресурсу есть, false - если доступ к ресурсу отсутствует
     */
    private boolean validAccessToResource(ResourceDAO resourceDAO, String resource, String role, String login) throws SQLException {
        Resources res = resourceDAO.getResource(resource, role, login);
        if (res == null) {
            logger.error("Ошибка доступа");
            return false;
        }
        return true;
    }

    /**
     * Проверка авторизации
     *
     * @param resourceDAO - ресурс из БД
     * @param resource - ресурс из аругментов
     * @param role - роль из аругментов
     * @param isAuthentication - проверка аутентификации
     * @return - системная ошибка с кодом, либо true если все совпадает
     */
    public boolean isAuthorization(ResourceDAO resourceDAO, String resource, String role, boolean isAuthentication, String login)
            throws SQLException {
        if ((isAuthentication) && (role != null) && (resource != null)) {
            if (!Roles.isCheckInRole(role)) {
                System.exit(3);
            }
            if (!validAccessToResource(resourceDAO, resource, role, login)) {
                System.exit(4);
            }
            return true;
        }
        logger.trace("Авторизация не пройдена. Нет аругментов.");
        return false;
    }
}
