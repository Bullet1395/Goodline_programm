import Enums.Roles;
import Library_classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        ParseCMD cmd_args = new ParseCMD();
        cmd_args.parse(args);

        Users userRead = new Users("User_Read", "123_r");
        Users userWrite = new Users("User_Write", "123_w");
        Users userExecute = new Users("User_Execute", "123_e");

        Resources res1 = new Resources("User_Read", Roles.READ, "C.R.RR");
        Resources res2 = new Resources("User_Read", Roles.READ, "C.W.WR.R");
        Resources res3 = new Resources("User_Write", Roles.WRITE, "C.W.WR");
        Resources res4 = new Resources("User_Write", Roles.WRITE, "C.R.RR.W");
        Resources res5 = new Resources("User_Execute", Roles.EXECUTE, "C.E.ER");

        ArrayList<Users> users = new ArrayList<>();
        users.add(userRead);
        users.add(userWrite);
        users.add(userExecute);

        List<Resources> resources = new ArrayList<>();
        resources.add(res1);
        resources.add(res2);
        resources.add(res3);
        resources.add(res4);
        resources.add(res5);

        Users authentUser = Authentification.sLog_IN(users);

        if (ParseCMD.isCheckOption("r") && ParseCMD.isCheckOption("path")) {
            Authorization.checkParam(authentUser, resources, ParseCMD.getRole(), ParseCMD.getPath());
            if (ParseCMD.isCheckOption("ds") && ParseCMD.isCheckOption("de") && ParseCMD.isCheckOption("v")) {
                Accaunting.checkParam(ParseCMD.getDateIn(), ParseCMD.getDateOut(), ParseCMD.getVolume());
                System.exit(0);
            } else System.exit(0);
        }
    }
}
