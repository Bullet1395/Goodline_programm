package Library_classes;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Authentification {

    public static Users Log_IN(ArrayList<Users> users) throws NoSuchAlgorithmException {
        Users aut_user = new Users();
        String aut_log = ParseCMD.getLogin();
        for (Users u : users) {
            String userLogin = u.GetLogin();
            if (aut_log.equals(userLogin)) {
                aut_user.SetLogin(aut_log);
                aut_user.SetSalt(u.GetSalt());
                aut_user.SetPassword(ParseCMD.getPassword());
                if (aut_user.GetPassword().equals(u.GetPassword())) {
                    if (ParseCMD.checkOption("r") == true && ParseCMD.checkOption("path") == true)
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