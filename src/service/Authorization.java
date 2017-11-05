package service;

import domain.Resources;
import domain.Users;
import domain.enums.Roles;

import java.util.List;

public class Authorization {
    /**
     * Проверяет параметры для авторизации
     *
     * @param user аутентифицированный пользователь(логин)
     * @param resources коллекция с ресурсами(таблица)
     * @param role роль переданная из аргументов
     * @param path путь переданный из аргументов
     */
    public static void checkParam(Users user, List<Resources> resources, String role, String path) {
        int iter = 0;
        int iter2 = countInUser(resources, user.getLogin());
        for (Resources res : resources) {
            if (user.getLogin().equals(res.getUser())) {
                iter++;
                if (isCheckAccess(role, path, res, iter, iter2)){
                    break;
                }
            } else if (resources.indexOf(res) == resources.size()) {
                System.exit(1);
            }
        }
    }

    /**
     * Проверяет, есть ли пользователь в таблице с ресурсами
     * т.е. есть ли на его имя какие-то записи
     * и количество этих записей
     *
     * @param resources коллекция с ресурсами(таблица)
     * @param user аутентифицированный пользователь(логин)
     * @return количество записей в таблице с данным логином
     */
    private static int countInUser(List<Resources> resources, String user) {
        int countUs = 0;
        for (Resources res : resources) {
            if (res.getUser().equals(user)) {
                countUs++;
            }
        }
        return countUs;
    }

    /**
     * Проверяет доступ к ресурсу
     *
     * @param role роль переданная из аргументов
     * @param path путь переданный из аргументов
     * @param res проверяемый ресурс(запись из таблицы)
     * @param iter
     * @param iter2
     * @return true или false
     */
    private static boolean isCheckAccess(String role, String path, Resources res, int iter, int iter2){
        if (Roles.isCheckInRole(role)) {
            if (isCheckPathRole(path, res)) {
                if (isCheckRoleToResource(role, res, iter, iter2)){
                    return true;
                }
            } else if (iter == iter2) {
                System.exit(4);
            }
        }
        return false;
    }

    /**
     * Проверяет полученный путь ресурса из параметров(p1) с записью в таблице ресурсов(p2)
     * Если количество символов p1 >= p2 тогда идет сравнение путей.
     * у p2 остается столько символов сколько у p1, это позволяет реализоавть доступ ко всем внутренним папкам
     * с такой же ролью. Проверка на роль была уже пройдена другим методом.
     * т.е. есть запись в таблице C.R.RR, а передалась C.R.RR.T.G.H. т.к. у нас есть доступ к RR, а все остальные это вложенные
     * ресурсы то к ним мы тоже получаем доступ.
     * Если символов меньше, чем в записи таблицы, выходим из метода и проверяем следующую запись с таким именем пользователя
     *
     * @param path путь переданный из аргументов
     * @param resource проверяемый ресурс(запись из таблицы)
     * @return true или false
     */
    private static boolean isCheckPathRole(String path, Resources resource) {
        if (path.length() >= resource.getPath().length()) {
            String p1 = resource.getPath();
            String p2 = path.substring(0, resource.getPath().length());
            return p1.equals((p2));
        }
        return false;
    }

    /**
     * Проверка роли ресурса
     *
     * @param role роль переданная из аргументов
     * @param res проверяемый ресурс(запись из таблицы)
     * @param iter
     * @param iter2
     * @return true если все проверено успешно, false иначе.
     */
    private static boolean isCheckRoleToResource(String role, Resources res, int iter, int iter2){
        /*
         * Задает роль полученную из параметров Roles.valueOf(role)
         * сравнивает с ролью у проверяемого ресурса res.getRole()
         */
        if (Roles.valueOf(role) == res.getRole()) {
            return true;
        } else if (iter == iter2) {
            System.exit(4);
        }
        return false;
    }
}
