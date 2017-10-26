package Library_classes;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;

public class ParseCMD {

    private final static String Login = "login";
    private final static String Password = "password";
    private final static String Role = "role";
    private final static String Path = "path";

    private Options options;
    private static CommandLine line;

    public ParseCMD() {
        options = new Options();
        options.addOption(Option.builder("l")
                .longOpt(Login)
                .desc("Логин пользователя")
                .hasArg()
                .argName("LOGIN")
                .build());
        options.addOption(Option.builder("p")
                .longOpt(Password)
                .desc("Пароль")
                .hasArg()
                .argName("PASSWORD")
                .build());
        options.addOption(Option.builder("h")
                .longOpt("help")
                .desc("Вывод справки")
                .build());
        options.addOption(Option.builder("r")
                .longOpt(Role)
                .desc("Роль")
                .hasArg()
                .argName("ROLE")
                .build());
        options.addOption(Option.builder()
                .longOpt(Path)
                .desc("Путь до ресурса")
                .hasArg()
                .argName("PATH")
                .build());
    }

    public static String getLogin() {
        return getOption(Login);
    }

    public static String getPassword() {
        return getOption(Password);
    }

    public static String getRole() {
        return getOption(Role);
    }

    public static String getPath() {
        return getOption(Path);
    }

    public void Parse(String[] args) throws Exception {
        try {
            CommandLineParser parser = new DefaultParser();
            line = parser.parse(options, args);
            if (line.hasOption("help")) {
                throw new Exception(PrintHelp());
            }
        } catch (Exception e) {
        }
    }

    public static String getOption(String optionName) {
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

    public static boolean checkOption(String optionName){
        return line.hasOption(optionName);
    }

    private String PrintHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Goodline application", "Прочитайте инструкцию к программе",
                options, "Разработано: Bullet1395");
        return formatter.toString();
    }
}
