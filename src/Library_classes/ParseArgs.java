package Library_classes;

import Enums.Constants;
import org.apache.commons.cli.CommandLine;

public class ParseArgs {

    private static CommandLine line = ParseCMD.getLine();

    private static String getOption(String optionName) {
        String opt = "";
        if (line.hasOption(optionName)) {
            try {
                opt = line.getOptionValue(optionName);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            return opt;
        } else {
            return opt;
        }
    }

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
