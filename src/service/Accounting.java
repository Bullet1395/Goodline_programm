package service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Accounting {
    public static LocalDate isCheckDate(String date){
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException | NullPointerException e) {
            System.exit(5);
            return null;
        }
    }

    public static Integer isCheckVolume(String volume){
        try {
            return Integer.parseInt(volume);
        } catch (DateTimeParseException | NullPointerException  | NumberFormatException e) {
            System.exit(5);
            return null;
        }
    }
}
