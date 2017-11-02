import domain.Accaunts;
import domain.Resources;
import domain.Users;
import domain.enums.Roles;
import service.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ParseCommLine cmd_args = new ParseCommLine();
        cmd_args.parse(args);

        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users("User_Read", "123_r"));
        users.add(new Users("User_Write", "123_w"));
        users.add(new Users("User_Execute", "123_e"));

        ArrayList<Resources> resources = new ArrayList<>();
        resources.add(new Resources("User_Read", Roles.READ, "C.R.RR"));
        resources.add(new Resources("User_Read", Roles.READ, "C.W.WR.R"));
        resources.add(new Resources("User_Write", Roles.WRITE, "C.W.WR"));
        resources.add(new Resources("User_Write", Roles.WRITE, "C.R.RR.W"));
        resources.add(new Resources("User_Execute", Roles.EXECUTE, "C.E.ER"));

        Users authentUser = Authentification.Log_IN(users);
        ArrayList<Accaunts> accaunts = new ArrayList<>();

        if (ParseCommLine.isCheckOption("r") && ParseCommLine.isCheckOption("path")) {
            Authorization.checkParam(authentUser, resources, ParseArgs.getRole(), ParseArgs.getPath());

            if (ParseCommLine.isCheckOption("ds") && ParseCommLine.isCheckOption("de") && ParseCommLine.isCheckOption("v")) {
                Accaunting.checkParam(ParseArgs.getDateIn(), ParseArgs.getDateOut(), ParseArgs.getVolume());
                accaunts.add(new Accaunts(new SimpleDateFormat("yyyy-MM-dd").parse(ParseArgs.getDateIn()),
                        new SimpleDateFormat("yyyy-MM-dd").parse(ParseArgs.getDateOut()),
                        Integer.parseInt(ParseArgs.getVolume())));
                System.exit(0);
            } else {
                System.exit(0);
            }
        }
    }
}
