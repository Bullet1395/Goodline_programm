package Library_classes;

import org.apache.commons.cli.CommandLine;

public class ParseArgs {
    private final static String LOGIN = "login";
    private final static String PASSWORD = "password";
    private final static String ROLE = "role";
    private final static String PATH = "path";
    private final static String DATE_IN = "ds";
    private final static String DATE_OUT = "de";
    private final static String VOLUME = "volume";

    private static CommandLine line = ParseCMD.getLine();

    private static String getOption(String optionName) {
        String opt = "";
        if (line.hasOption(optionName)) {
            try {
                opt = line.getOptionValue(optionName);
            } catch (NumberFormatException e) {
            }
            return opt;
        } else {
            return opt;
        }
    }

    static String getLogin() {
        return getOption(LOGIN);
    }

    static String getPassword() {
        return getOption(PASSWORD);
    }

    public static String getRole() {
        return getOption(ROLE);
    }

    public static String getPath() {
        return getOption(PATH);
    }

    public static String getDateIn() {
        return getOption(DATE_IN);
    }

    public static String getDateOut() {
        return getOption(DATE_OUT);
    }

    public static String getVolume() {
        return getOption(VOLUME);
    }
}
