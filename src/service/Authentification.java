package service;

import domain.Users;
import domain.enums.Constants;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Authentification {
    public static Users logIn(ArrayList<Users> users) {
        String autLog = ParseCommLine.getArg(Constants.LOGIN.name());
        Users autUser = new Users(autLog, "pass");

        for (Users userInBase : users) {
            String userLogin = userInBase.getLogin();

            try {
                if (autLog.equals(userLogin)) {
                    autUser.setSalt(userInBase.getSalt());
                    autUser.setPassword(ParseCommLine.getArg(Constants.PASSWORD.name()));
                    checkUser(autUser, userInBase);
                    return autUser;
                }
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e.getMessage());
            }

            if (users.indexOf(userInBase) == (users.size() - 1)) {
                System.exit(1);
            }
        }
        return autUser;
    }

    private static void checkUser(Users autUser, Users userInBase){
        if (autUser.getPassword().equals(userInBase.getPassword())) {

            if (!ParseCommLine.isCheckOption("r") || !ParseCommLine.isCheckOption("path")) {
                System.exit(0);
            }
        } else {
            System.exit(2);
        }
    }
}