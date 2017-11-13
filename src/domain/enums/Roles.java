package domain.enums;

public enum Roles {
    READ,
    WRITE,
    EXECUTE;

    /**
     * Проверяет есть ли переданная из параметров роль в списке Enum ролей
     *
     * @param role роль переданная из аргументов
     * @return true или false
     */
    public static boolean isCheckInRole(String role) {
        for (Roles r : Roles.values()) {
            if (r.name().equals(role)) {
                return true;
            }
        }
        System.exit(3);
        return false;
    }
}


