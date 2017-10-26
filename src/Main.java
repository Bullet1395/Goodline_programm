import Enums.Roles;
import Library_classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
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

        ArrayList<Users> users = new ArrayList<>();
        users.add(User_Read);
        users.add(User_Write);
        users.add(User_Execute);

        List<Resources> resources = new ArrayList<>();
        resources.add(res_1);
        resources.add(res_2);
        resources.add(res_3);
        resources.add(res_4);
        resources.add(res_5);

        Users Authentification_User = Users.Log_IN(users);

        if (ParseCMD.checkOption("r") == true && ParseCMD.checkOption("path") == true)
            Resources.CheckParam(Authentification_User, resources, ParseCMD.getRole(), ParseCMD.getPath());
    }
}
