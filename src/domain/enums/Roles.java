package domain.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.Authentication;

public enum Roles {
    READ,
    WRITE,
    EXECUTE;

    private static final Logger logger = LogManager.getLogger(Authentication.class.getName());

    /**
     * Проверяет есть ли переданная из параметров роль в списке Enum ролей
     *
     * @param role роль переданная из аргументов
     * @return роль или null
     */
    public static boolean isCheckInRole(String role) {
        for (Roles r : Roles.values()) {
            if (r.name().equals(role)) {
                return true;
            }
        }
        logger.error("Роль не найдена");
        return false;
    }
}


