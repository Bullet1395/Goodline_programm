package service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Accaunting {
    public static LocalDate isCheckData(String date){
        try {
            return LocalDate.parse(date);
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
