package Library_classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Accaunting {
    public static void checkParam(String dateIn, String dateOut, String volume){
        if (isCheckData(dateIn) && isCheckData(dateOut)){
            isCheckVolume(volume);
        }
    }

    private static boolean isCheckData(String data){
        String pat = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(data);
        if (m.matches()) {
            return true;
        } else System.exit(5);
        return false;
    }

    private static void isCheckVolume(String volume){
        String pat = "[0-9]+";
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(volume);
        if (!m.matches()) {
            System.exit(5);
        }
    }
}
