package Library_classes;

import Security.EncryptedPass;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

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
}
