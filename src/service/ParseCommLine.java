package service;

import org.apache.commons.cli.*;

public class ParseCommLine {
    private Options options;
    private static CommandLine line;

    public ParseCommLine() {
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

    public void parse(String[] args) {
        try {
            CommandLineParser parser = new DefaultParser();
            line = parser.parse(options, args);
            checkOptionHelp(args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            printHelp();
        }
    }

    private void checkOptionHelp(String[] args) throws Exception {
        if (line.hasOption("help") || args.length == 0) {
            throw new Exception(printHelp());
        }
    }

    static String getOption(String optionName) {
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

    public static boolean isCheckOption(String optionName){
        return line.hasOption(optionName);
    }

    public static String getArg(String arg) {
        return getOption(arg.toLowerCase());
    }

    private String printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Goodline application", "Справка",
                options, "...");
        return formatter.toString();
    }
}
