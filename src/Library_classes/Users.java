package Library_classes;

import Security.EncryptedPass;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Users
{
    private String mLogin;
    private String mPassword;
    private String mSalt;

    private static String sSetSalt()
    {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        return Arrays.toString(bytes);
    }

    Users()
    {
        this.mLogin = "Login";
        this.mSalt = "Salt";
        this.mPassword = "Password";
    }

    public Users(String Login, String Password) throws NoSuchAlgorithmException
    {
        this.mLogin = Login;
        this.mSalt = sSetSalt();
        this.mPassword = EncryptedPass.hashPassword(Password, mSalt);
    }

    String getLogin()
    {
        return this.mLogin;
    }

    String getPassword()
    {
        return this.mPassword;
    }

    String getSalt()
    {
        return this.mSalt;
    }

    void setSalt(String Salt)
    {
        this.mSalt = Salt;
    }

    void setLogin(String Login)
    {
        this.mLogin = Login;
    }

    void setPassword(String Password) throws NoSuchAlgorithmException
    {
        this.mPassword = EncryptedPass.hashPassword(Password, mSalt);
    }
}
