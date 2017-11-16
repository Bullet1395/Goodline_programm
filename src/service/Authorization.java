package service;

import domain.Resources;
import domain.Users;
import domain.enums.Roles;

import java.util.List;

public class Authorization {
    /**
     * Проверяет параметры для авторизации
     *
     * @param user      аутентифицированный пользователь(логин)
     * @param resources коллекция с ресурсами(таблица)
     * @param role      роль переданная из аргументов
     * @param path      путь переданный из аргументов
     */
    public static void checkParam(Users user, List<Resources> resources, String role, String path) {
        for (Resources res : resources) {
            if (user.getLogin().equals(res.getUser())) {
                if (isCheckAccess(role, path, res)) {
                    return;
                }
            }
        }
        System.exit(4);
    }

    /**
     * Проверяет доступ к ресурсу
     *
     * @param role      роль переданная из аргументов
     * @param path      путь переданный из аргументов
     * @param res       проверяемый ресурс(запись из таблицы)
     * @return true или false
     */
    private static boolean isCheckAccess(String role,
                                         String path,
                                         Resources res) {
        return Roles.isCheckInRole(role) &&
                isCheckRoleToResource(role, res) &&
                isCheckPathRole(path, res);
    }

    /**
     * Проверяет полученный путь ресурса из параметров(pathResourceFromArg) с записью в таблице ресурсов(pathResource)
     * Если количество символов pathResourceFromArg >= pathResource тогда идет сравнение путей.
     * у p2 остается столько символов сколько у p1, это позволяет реализоавть доступ ко всем внутренним папкам
     * с такой же ролью. Проверка на роль была уже пройдена другим методом.
     * т.е. есть запись в таблице C.R.RR, а передалась C.R.RR.T.G.H. т.к. у нас есть доступ к RR,
     * а все остальные это вложенные
     * ресурсы то к ним мы тоже получаем доступ.
     * Если символов меньше, чем в записи таблицы, выходим из метода и проверяем следующую запись
     * с таким именем пользователя
     *
     * @param path     путь переданный из аргументов
     * @param resource проверяемый ресурс(запись из таблицы)
     * @return true или false
     */
    private static boolean isCheckPathRole(String path, Resources resource) {
        if (path.length() >= resource.getPath().length()) {
            String pathResourceFromArg = resource.getPath();
            String pathResource = path.substring(0, resource.getPath().length());
            return pathResourceFromArg.equals((pathResource));
        }
        return false;
    }

    /**
     * Проверка роли у ресурса
     *
     * @param role      роль переданная из аргументов
     * @param res       проверяемый ресурс(запись из таблицы)
     */
    private static boolean isCheckRoleToResource(String role, Resources res) {
        /*
         * Задает роль полученную из параметров Roles.valueOf(role)
         * сравнивает с ролью у проверяемого ресурса res.getRole()
         */
        if (Roles.valueOf(role) != res.getRole()) {
            System.exit(4);
        }
        return true;
    }
}
