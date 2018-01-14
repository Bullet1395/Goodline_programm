package service;

import DAO.ResourceDAO;
import domain.Resources;
import domain.Users;
import domain.enums.Roles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

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
    private boolean validAccessToResource(ResourceDAO resourceDAO, String resource, String role) throws SQLException {
        Resources res = resourceDAO.getResource(resource, role);
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
    public boolean isAuthorization(ResourceDAO resourceDAO, String resource, String role, boolean isAuthentication)
            throws SQLException {
        if ((isAuthentication) && (role != null) && (resource != null)) {
            if (!Roles.isCheckInRole(role)) {
                System.exit(3);
            }
            if (!validAccessToResource(resourceDAO, resource, role)) {
                System.exit(4);
            }
            return true;
        }
        return false;
    }
}
