package Library_classes;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Authentification {
    public static Users sLog_IN(ArrayList<Users> users) throws NoSuchAlgorithmException {
        Users autUser = new Users();
        String autLog = ParseCMD.getLogin();
        for (Users u : users) {
            String userLogin = u.getLogin();
            if (autLog.equals(userLogin)) {
                autUser.setLogin(autLog);
                autUser.setSalt(u.getSalt());
                autUser.setPassword(ParseCMD.getPassword());
                if (autUser.getPassword().equals(u.getPassword())) {
                    if (ParseCMD.isCheckOption("r") && ParseCMD.isCheckOption("path")) {
                        return autUser;
                    }
                    System.exit(0);
                } else {
                    System.exit(2);
                }
            }
            if (users.indexOf(u) == (users.size() - 1)) {
                System.exit(1);
            }
        }
        return autUser;
    }
}