package Library_classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accaunting {

    public static void CheckParam(String DateIn, String DateOut, String Volume){
        if (CheckData(DateIn) && CheckData(DateOut)){
            CheckVolume(Volume);
            System.exit(0);
        }
    }

    private static boolean CheckData(String Data){
        String pat = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(Data);
        if (m.matches()) {
            return true;
        } else System.exit(5);
        return false;
    }

    private static boolean CheckVolume(String Volume){
        String pat = "[0-9]+";
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(Volume);
        if (m.matches()) {
            return true;
        } else System.exit(5);
        return false;
    }
}
