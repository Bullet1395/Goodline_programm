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
        users.add(new Users("User_Read", "123_r"));
        users.add(new Users("User_Write", "123_w"));
        users.add(new Users("User_Execute", "123_e"));

        ArrayList<Resources> resources = new ArrayList<>();
        resources.add(new Resources("User_Read", Roles.READ, "C.R.RR"));
        resources.add(new Resources("User_Read", Roles.READ, "C.W.WR.R"));
        resources.add(new Resources("User_Write", Roles.WRITE, "C.W.WR"));
        resources.add(new Resources("User_Write", Roles.WRITE, "C.R.RR.W"));
        resources.add(new Resources("User_Execute", Roles.EXECUTE, "C.E.ER"));

        Users authentUser = Authentification.logIn(users);
        ArrayList<Accounts> accounts = new ArrayList<>();

        if (ParseCommLine.isCheckOption("r") && ParseCommLine.isCheckOption("path")) {
            Authorization.checkParam(authentUser, resources, ParseArgs.getArg(Constants.ROLE.name()), ParseArgs.getArg(Constants.PATH.name()));

            if (ParseCommLine.isCheckOption("ds") && ParseCommLine.isCheckOption("de") && ParseCommLine.isCheckOption("v")) {
                Accaunting.checkParam(ParseArgs.getArg(Constants.DATE_IN.name()),
                        ParseArgs.getArg(Constants.DATE_OUT.name()),
                        ParseArgs.getArg(Constants.VOLUME.name()));
                try {
                    accounts.add(new Accounts(
                            new SimpleDateFormat("yyyy-MM-dd").parse(ParseArgs.getArg(Constants.DATE_IN.name())),
                            new SimpleDateFormat("yyyy-MM-dd").parse(ParseArgs.getArg(Constants.DATE_OUT.name())),
                            Integer.parseInt(ParseArgs.getArg(Constants.VOLUME.name()))));
                    System.exit(0);
                } catch (ParseException e){
                    System.out.println("Неправильный формат ввода" + '\n' + e.getMessage());
                }
            } else {
                System.exit(0);
            }
        }
    }
}
