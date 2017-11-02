package service;

import static service.ParseCommLine.getOption;

public class ParseArgs {
    public static String getArg(String arg) {
        return getOption(arg.toLowerCase());
    }
}
