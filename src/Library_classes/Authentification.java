package Library_classes;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Authentification {

    public static Users sLog_IN(ArrayList<Users> users) throws NoSuchAlgorithmException {
        Users aut_user = new Users();
        String aut_log = ParseCMD.getLogin();
        for (Users u : users) {
            String userLogin = u.getLogin();
            if (aut_log.equals(userLogin)) {
                aut_user.setLogin(aut_log);
                aut_user.setSalt(u.getSalt());
                aut_user.setPassword(ParseCMD.getPassword());
                if (aut_user.getPassword().equals(u.getPassword())) {
                    if (ParseCMD.ischeckOption("r") && ParseCMD.ischeckOption("path"))
                        return aut_user;
                    System.exit(0);
                } else
                    System.exit(2);
            }
            if (users.indexOf(u) == (users.size() - 1))
                System.exit(1);
        }
        return aut_user;
    }
}