package service;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.HelpFormatter;

public class ParseCommLine {
    private Options options;
    private CommandLine line;

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

    public CommLineArgs parse(String[] args) {
        try {
            CommandLineParser parser = new DefaultParser();
            line = parser.parse(options, args);
            checkOptionHelp(args);
            return new CommLineArgs()
                    .withLogin(line.getOptionValue("login"))
                    .withPassword(line.getOptionValue("password"))
                    .withRole(line.getOptionValue("role"))
                    .withPath(line.getOptionValue("path"))
                    .withDateIn(line.getOptionValue("dateIn"))
                    .withDateOut(line.getOptionValue("dateOut"))
                    .withVolume(line.getOptionValue("volume"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            printHelp();
        }
        return null;
    }

    String printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Goodline application", "Справка",
                options, "...");
        return formatter.toString();
    }

    private void checkOptionHelp(String[] args) throws Exception {
        if (line.hasOption("help") || args.length == 0) {
            throw new Exception(printHelp());
        }
    }
}
