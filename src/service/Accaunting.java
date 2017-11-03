package service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Accaunting {
    public static LocalDate isCheckData(String data){
        try {
            return LocalDate.parse(data);
        } catch (DateTimeParseException e) {
            System.exit(5);
            return null;
        }
    }

    public static Integer isCheckVolume(String volume){
        try {
            return Integer.parseInt(volume);
        } catch (NumberFormatException e) {
            System.exit(5);
            return null;
        }
    }
}
