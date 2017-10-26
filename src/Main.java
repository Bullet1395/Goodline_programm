import Enums.Roles;
import Library_classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        /*Authentification authen = new Authentification();
        authen.Parse(args);
        Authorization authoriz = new Authorization();
        authoriz.Parse(args);*/

        ParseCMD cmd_args = new ParseCMD();
        cmd_args.Parse(args);

        Users User_Read = new Users("User_Read", "123_r");
        Users User_Write = new Users("User_Write", "123_w");
        Users User_Execute = new Users("User_Execute", "123_e");

        Resources res_1 = new Resources("User_Read", Roles.READ, "C.R.RR");
        Resources res_2 = new Resources("User_Read", Roles.READ, "C.W.WR.R");
        Resources res_3 = new Resources("User_Write", Roles.WRITE, "C.W.WR");
        Resources res_4 = new Resources("User_Write", Roles.WRITE, "C.R.RR.W");
        Resources res_5 = new Resources("User_Execute", Roles.EXECUTE, "C.E.ER");

        List<Users> users = new ArrayList<>();
        users.add(User_Read);
        users.add(User_Write);
        users.add(User_Execute);

        List<Resources> resources = new ArrayList<>();
        resources.add(res_1);
        resources.add(res_2);
        resources.add(res_3);
        resources.add(res_4);
        resources.add(res_5);

        Users aut_user = new Users();
        String aut_log = ParseCMD.getLogin();

        outer: for (Users u : users) {
            String userLogin = u.GetLogin();
            if (aut_log.equals(userLogin)) {
                //aut_user = new Users();
                aut_user.SetLogin(aut_log);
                aut_user.SetSalt(u.GetSalt());
                aut_user.SetPassword(ParseCMD.getPassword());
                if (aut_user.GetPassword().equals(u.GetPassword())) {
                    if (ParseCMD.checkOption("r") == true && ParseCMD.checkOption("path") == true)
                        break outer;
                    System.exit(0);
                } else
                    System.exit(2);
            }
            if (users.indexOf(u) == (users.size() - 1))
                System.exit(1);
        }

        if (ParseCMD.checkOption("r") == true && ParseCMD.checkOption("path") == true)
            Resources.CheckParam(aut_user, resources, ParseCMD.getRole(), ParseCMD.getPath());
    }
}
