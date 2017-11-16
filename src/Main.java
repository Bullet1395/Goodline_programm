import domain.Accounts;
import domain.Resources;
import domain.Users;
import domain.enums.Roles;
import service.*;
import service.security.EncryptedPass;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParseCommLine cmdArgs = new ParseCommLine();
        CommLineArgs arguments = cmdArgs.parse(args);

        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users("User_Read", "123_r", EncryptedPass.setSalt()));
        users.add(new Users("User_Write", "123_w", EncryptedPass.setSalt()));
        users.add(new Users("User_Execute", "123_e", EncryptedPass.setSalt()));

        ArrayList<Resources> resources = new ArrayList<>();
        resources.add(new Resources("User_Read", Roles.READ, "C.R.RR"));
        resources.add(new Resources("User_Read", Roles.READ, "C.W.WR.R"));
        resources.add(new Resources("User_Write", Roles.WRITE, "C.W.WR"));
        resources.add(new Resources("User_Write", Roles.WRITE, "C.R.RR.W"));
        resources.add(new Resources("User_Execute", Roles.EXECUTE, "C.E.ER"));

        Users authentUser = null;
        ArrayList<Accounts> accounts = new ArrayList<>();

        if (arguments.isAuthentication()) {
            authentUser = Authentication.logIn(users, arguments);
        }
        if (arguments.isAuthorization()) {
            Authorization.checkParam(
                    authentUser,
                    resources,
                    arguments.getRole(),
                    arguments.getPath());
        }
        if (arguments.isAccounting()) {
            accounts.add(new Accounts(
                    Accounting.isCheckDate(arguments.getDateIn()),
                    Accounting.isCheckDate(arguments.getDateOut()),
                    Accounting.isCheckVolume(arguments.getVolume())));
        }
        System.exit(0);
    }
}
