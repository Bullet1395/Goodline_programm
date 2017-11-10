package service;

import domain.Users;

import java.util.ArrayList;

public class Authentification {
    /**
     * Метод для аутентификации пользователя.
     * Проверяет входные данне со всеми пользователями в коллекции
     * 
     * @param users коллекция(таблица) с пользователями в программе
     * @return если проверка пройдена, возвращает аутентифицированного пользователя
     */
    public static Users logIn(ArrayList<Users> users, CommLineArgs arguments) {
        try {
            if (arguments.isAuthentification()) {
                String autLog = arguments.getLogin();
                for (Users userInBase : users) {
                    if (autLog.equals(userInBase.getLogin())) {
                        return checkUser(new Users(
                                        autLog,
                                        arguments.getPassword(),
                                        userInBase.getSalt()),
                                userInBase);
                    }
                }
            }
            new ParseCommLine().printHelp();
            System.exit(1);
        } catch (NullPointerException e){
            new ParseCommLine().printHelp();
            System.exit(1);
        }
        return null;
    }

    /**
     * Проверяет данные введенные для аутентификации с данными в таблице
     *
     * @param autUser созданный пользователь с данными из параметров коммандной строки для проверки с данными в таблице
     * @param userInBase пльзователь из таблицы с таким же логином
     * @return если проверка пройдена, возвращает аутентифицированного пользователя
     */
    private static Users checkUser(Users autUser, Users userInBase){
        /*
         * Сравнивание паролей. Если совпадут то идет проверка на наличие других параметров в строке аргументов,
         * если их нету, то возвращает код 0. Если есть, возвращает пользоавтеля для авторизации.
         */
        if (autUser.getPassword().equals(userInBase.getPassword())) {
            return autUser;
        } else {
            System.exit(2);
        }
        return null;
    }
}