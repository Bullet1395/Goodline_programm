import domain.Accounts;
import domain.Resources;
import domain.Users;
import domain.enums.Constants;
import domain.enums.Roles;
import org.apache.commons.cli.CommandLine;
import service.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParseCommLine cmdArgs = new ParseCommLine();
        CommandLine line = cmdArgs.parse(args);

        CommLineArgs arguments = new CommLineArgs();
        arguments.fillArgs(line);

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

        Users authentUser = Authentification.logIn(users, arguments);
        ArrayList<Accounts> accounts = new ArrayList<>();

        if (CommLineArgs.isCheckArg(Constants.ROLE.name(), arguments) && CommLineArgs.isCheckArg(Constants.PATH.name(), arguments)) {
            Authorization.checkParam(
                    authentUser,
                    resources,
                    arguments.getArg(Constants.ROLE.name()),
                    arguments.getArg(Constants.PATH.name()));

            if (CommLineArgs.isCheckArg(Constants.DATE_IN.name(), arguments)
                    && CommLineArgs.isCheckArg(Constants.DATE_OUT.name(), arguments)
                    && CommLineArgs.isCheckArg(Constants.VOLUME.name(), arguments)) {
                accounts.add(new Accounts(
                        Accaunting.isCheckData(arguments.getArg(Constants.DATE_IN.name())),
                        Accaunting.isCheckData(arguments.getArg(Constants.DATE_OUT.name())),
                        Accaunting.isCheckVolume(arguments.getArg(Constants.VOLUME.name()))));
                System.exit(0);
            } else {
                System.exit(0);
            }
        }
    }
}
