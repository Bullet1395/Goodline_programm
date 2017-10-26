package Library_classes;

import Enums.Roles;
import org.apache.commons.cli.*;

/*public class Authorization {
    private final static String User = "USER";
    private final static String Role = "ROLE";
    private final static String Path = "PATH";

    private Options options;
    private CommandLine line;

    public Authorization() {
        options = new Options();
        options.addOption(Option.builder("u")
                .longOpt(User)
                .desc("Логин пользователя")
                .hasArg()
                .argName("USER")
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

    public String getUser() {
        return getOption(User);
    }

    public String getRole() {
        return getOption(Role);
    }

    public String getPath() {
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

    private String PrintHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Goodline application", "Прочитайте инструкцию к программе",
                options, "Разработано: Bullet1395");
        return formatter.toString();
    }

    public String getOption(String optionName) {
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
}*/
