package Library_classes;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Authentification {
    public static Users sLog_IN(ArrayList<Users> users) throws NoSuchAlgorithmException {
        String autLog = ParseArgs.getLogin();
        Users autUser = new Users(autLog, "pass");

        for (Users userInBase : users) {
            String userLogin = userInBase.getLogin();
            if (autLog.equals(userLogin)) {
                autUser.setSalt(userInBase.getSalt());
                autUser.setPassword(ParseArgs.getPassword());
                checkUser(autUser, userInBase);
                return autUser;
            }
            if (users.indexOf(userInBase) == (users.size() - 1)) {
                System.exit(1);
            }
        }
        return autUser;
    }

    private static void checkUser(Users autUser, Users userInBase){
        if (autUser.getPassword().equals(userInBase.getPassword())) {
            if (!ParseCMD.isCheckOption("r") || !ParseCMD.isCheckOption("path")) {
                System.exit(0);
            }
        } else {
            System.exit(2);
        }
    }

}