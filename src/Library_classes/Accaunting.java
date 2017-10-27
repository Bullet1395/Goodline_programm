package Library_classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accaunting {

    public static void checkParam(String DateIn, String DateOut, String Volume){
        if (isCheckData(DateIn) && isCheckData(DateOut)){
            isCheckVolume(Volume);
            System.exit(0);
        }
    }

    private static boolean isCheckData(String Data){
        String mpat = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
        Pattern mp = Pattern.compile(mpat);
        Matcher mm = mp.matcher(Data);
        if (mm.matches()) {
            return true;
        } else System.exit(5);
        return false;
    }

    private static boolean isCheckVolume(String Volume){
        String mpat = "[0-9]+";
        Pattern mp = Pattern.compile(mpat);
        Matcher mm = mp.matcher(Volume);
        if (mm.matches()) {
            return true;
        } else System.exit(5);
        return false;
    }
}
