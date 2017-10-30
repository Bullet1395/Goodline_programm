package Library_classes;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;

public class ParseCMD {
    private Options options;
    private static CommandLine line;

    public ParseCMD() {
        options = new Options();
        options.addOption(Option.builder("l")
                .longOpt("login")
                .desc("Логин пользователя")
                .hasArg()
                .argName("LOGIN")
                .build());
        options.addOption(Option.builder("p")
                .longOpt("password")
                .desc("Пароль")
                .hasArg()
                .argName("PASSWORD")
                .build());
        options.addOption(Option.builder("h")
                .longOpt("help")
                .desc("Вывод справки")
                .build());
        options.addOption(Option.builder("r")
                .longOpt("role")
                .desc("Роль")
                .hasArg()
                .argName("ROLE")
                .build());
        options.addOption(Option.builder()
                .longOpt("path")
                .desc("Путь до ресурса")
                .hasArg()
                .argName("PATH")
                .build());
        options.addOption(Option.builder("ds")
                .longOpt("date_in")
                .desc("Дата входа")
                .hasArg()
                .argName("DATE IN")
                .build());
        options.addOption(Option.builder("de")
                .longOpt("date_out")
                .desc("Дата выхода")
                .hasArg()
                .argName("DATE OUT")
                .build());
        options.addOption(Option.builder("v")
                .longOpt("volume")
                .desc("Объем")
                .hasArg()
                .argName("VOLUME")
                .build());
    }

    public void parse(String[] args) throws Exception {
        try {
            CommandLineParser parser = new DefaultParser();
            line = parser.parse(options, args);
            if (line.hasOption("help") || args.length == 0) {
                throw new Exception(printHelp());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static CommandLine getLine(){
        return line;
    }

    public static boolean isCheckOption(String optionName){
        return line.hasOption(optionName);
    }

    private String printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Goodline application", "Справка",
                options, "...");
        return formatter.toString();
    }
}
