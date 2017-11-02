package service;

import domain.enums.Constants;
import static service.ParseCommLine.getOption;

public class ParseArgs {
    static String getLogin() {
        return getOption(Constants.LOGIN.name().toLowerCase());
    }

    static String getPassword() {
        return getOption(Constants.PASSWORD.name().toLowerCase());
    }

    public static String getRole() {
        return getOption(Constants.ROLE.name().toLowerCase());
    }

    public static String getPath() {
        return getOption(Constants.PATH.name().toLowerCase());
    }

    public static String getDateIn() {
        return getOption(Constants.DATE_IN.name().toLowerCase());
    }

    public static String getDateOut() {
        return getOption(Constants.DATE_OUT.name().toLowerCase());
    }

    public static String getVolume() {
        return getOption(Constants.VOLUME.name().toLowerCase());
    }
}
