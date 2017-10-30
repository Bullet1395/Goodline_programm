package Library_classes;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Authentification {
    public static Users sLog_IN(ArrayList<Users> users) throws NoSuchAlgorithmException {
        String autLog = ParseArgs.getLogin();
        Users autUser = new Users(autLog, "pass");

        for (Users u : users) {
            String userLogin = u.getLogin();
            if (autLog.equals(userLogin)) {
                autUser.setSalt(u.getSalt());
                autUser.setPassword(ParseArgs.getPassword());
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