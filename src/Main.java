import Library_classes.Authentification;
import Library_classes.Users;
import Security.EncryptedPass;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        Authentification aut = new Authentification();
        aut.Parse(args);

        Users User_Read = new Users("User_Read", "123_r");
        Users User_Write = new Users("User_Write", "123_w");
        Users User_Execute = new Users("User_Execute", "123_e");

        List<Users> users = new ArrayList<>();
        users.add(User_Read);
        users.add(User_Write);
        users.add(User_Execute);

        Users aut_user;
        String aut_log = aut.getLogin();

        for (Users u : users)
        {
            String userLogin = u.GetLogin();
            if (aut_log.equals(userLogin))
            {
                aut_user = new Users();
                aut_user.SetLogin(aut_log);
                aut_user.SetSalt(u.GetSalt());
                aut_user.SetPassword(aut.getPassword());
                if (aut_user.GetPassword().equals(u.GetPassword()))
                {
                    System.exit(0);
                } else
                    System.exit(2);
            } if (users.indexOf(u) == (users.size()-1))
                System.exit(1);
        }
    }
}
