package Library_classes;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;

public class ParseCMD {
    private final static String LOGIN = "login";
    private final static String PASSWORD = "password";
    private final static String ROLE = "role";
    private final static String PATH = "path";
    private final static String DATE_IN = "ds";
    private final static String DATE_OUT = "de";
    private final static String VOLUME = "volume";

    private Options options;
    private static CommandLine line;

    public ParseCMD() {
        options = new Options();
        options.addOption(Option.builder("l")
                .longOpt(LOGIN)
                .desc("Логин пользователя")
                .hasArg()
                .argName("LOGIN")
                .build());
        options.addOption(Option.builder("p")
                .longOpt(PASSWORD)
                .desc("Пароль")
                .hasArg()
                .argName("PASSWORD")
                .build());
        options.addOption(Option.builder("h")
                .longOpt("help")
                .desc("Вывод справки")
                .build());
        options.addOption(Option.builder("r")
                .longOpt(ROLE)
                .desc("Роль")
                .hasArg()
                .argName("ROLE")
                .build());
        options.addOption(Option.builder()
                .longOpt(PATH)
                .desc("Путь до ресурса")
                .hasArg()
                .argName("PATH")
                .build());
        options.addOption(Option.builder("ds")
                .longOpt(DATE_IN)
                .desc("Дата входа")
                .hasArg()
                .argName("DATE IN")
                .build());
        options.addOption(Option.builder("de")
                .longOpt(DATE_OUT)
                .desc("Дата выхода")
                .hasArg()
                .argName("DATE OUT")
                .build());
        options.addOption(Option.builder("v")
                .longOpt(VOLUME)
                .desc("Объем")
                .hasArg()
                .argName("VOLUME")
                .build());
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

    public void parse(String[] args) throws Exception {
        try {
            CommandLineParser parser = new DefaultParser();
            line = parser.parse(options, args);
            if (line.hasOption("help") || args.length == 0) {
                throw new Exception(printHelp());
            }
        } catch (Exception e) {
        }
    }

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

    public static boolean isCheckOption(String optionName){
        return line.hasOption(optionName);
    }

    private String printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Goodline application", "Прочитайте инструкцию к программе",
                options, "Разработано: Bullet1395");
        return formatter.toString();
    }
}
