import domain.Accounts;
import domain.Resources;
import domain.Users;
import domain.enums.Constants;
import domain.enums.Roles;
import service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParseCommLine cmdArgs = new ParseCommLine();
        cmdArgs.parse(args);

        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users("User_Read", "123_r", Users.setSalt()));
        users.add(new Users("User_Write", "123_w", Users.setSalt()));
        users.add(new Users("User_Execute", "123_e", Users.setSalt()));

        ArrayList<Resources> resources = new ArrayList<>();
        resources.add(new Resources("User_Read", Roles.READ, "C.R.RR"));
        resources.add(new Resources("User_Read", Roles.READ, "C.W.WR.R"));
        resources.add(new Resources("User_Write", Roles.WRITE, "C.W.WR"));
        resources.add(new Resources("User_Write", Roles.WRITE, "C.R.RR.W"));
        resources.add(new Resources("User_Execute", Roles.EXECUTE, "C.E.ER"));

        Users authentUser = Authentification.logIn(users);
        ArrayList<Accounts> accounts = new ArrayList<>();

        if (ParseCommLine.isCheckOption("r") && ParseCommLine.isCheckOption("path")) {
            Authorization.checkParam(
                    authentUser,
                    resources,
                    ParseCommLine.getArg(Constants.ROLE.name()),
                    ParseCommLine.getArg(Constants.PATH.name()));

            if (ParseCommLine.isCheckOption("ds")
                    && ParseCommLine.isCheckOption("de")
                    && ParseCommLine.isCheckOption("v")) {
                accounts.add(new Accounts(
                        Accaunting.isCheckData(ParseCommLine.getArg(Constants.DATE_IN.name())),
                        Accaunting.isCheckData(ParseCommLine.getArg(Constants.DATE_OUT.name())),
                        Accaunting.isCheckVolume(ParseCommLine.getArg(Constants.VOLUME.name()))));
                System.exit(0);
            } else {
                System.exit(0);
            }
        }
    }
}
