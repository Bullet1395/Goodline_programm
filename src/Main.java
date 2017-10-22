import Library_classes.Users;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        Users User_Read = new Users("User_Read", "123_r");
        Users User_Write = new Users("User_Write", "123_w");
        Users User_Execute = new Users("User_Execute", "123_e");

        System.out.println(User_Read.GetLogin() + " " + User_Read.GetSalt() + " " + User_Read.GetPassword() + '\n');
        System.out.println(User_Write.GetLogin() + " " + User_Write.GetSalt() + " " + User_Write.GetPassword() + '\n');
    }
}
