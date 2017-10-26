package Library_classes;

import Security.EncryptedPass;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Users
{
    private String Login;
    private String Password;
    private String Salt;

    private static String SetSalt()
    {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        return bytes.toString();
    }

    public  Users()
    {
        this.Login = "Login";
        this.Salt = "Salt";
        this.Password = "Password";
    }

    public Users(String Login, String Password) throws NoSuchAlgorithmException
    {
        this.Login = Login;
        this.Salt = SetSalt();
        this.Password = EncryptedPass.hashPassword(Password, Salt);
    }

    public String GetLogin()
    {
        return this.Login;
    }

    public String GetPassword()
    {
        return this.Password;
    }

    public String GetSalt()
    {
        return this.Salt;
    }

    public void SetSalt(String Salt)
    {
        this.Salt = Salt;
    }

    public void SetLogin(String Login)
    {
        this.Login = Login;
    }

    public void SetPassword(String Password) throws NoSuchAlgorithmException
    {
        this.Password = EncryptedPass.hashPassword(Password, Salt);
    }
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
