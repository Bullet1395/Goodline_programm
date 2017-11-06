package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import domain.enums.Constants;
import org.apache.commons.cli.CommandLine;

public class CommLineArgs {
    private List<String> args;

    public CommLineArgs(){
        args = new ArrayList<>();
    }

    public void fillArgs(CommandLine line){
        for (Constants par: Constants.values()) {
            setArg(par.name(), line);
        }
    }

    private void setArg(String param, CommandLine line){
        switch (param) {
            case "LOGIN":
                args.add(0, getOption(param.toLowerCase(), line));
                break;
            case "PASSWORD":
                args.add(1, getOption(param.toLowerCase(), line));
                break;
            case "ROLE":
                args.add(2, getOption(param.toLowerCase(), line));
                break;
            case "PATH":
                args.add(3, getOption(param.toLowerCase(), line));
                break;
            case "DATE_IN":
                args.add(4, getOption(param.toLowerCase(), line));
                break;
            case "DATE_OUT":
                args.add(5, getOption(param.toLowerCase(), line));
                break;
            case "VOLUME":
                args.add(6, getOption(param.toLowerCase(), line));
                break;
        }
    }

    public String getArg(String param){
        switch (param) {
            case "LOGIN":
                return args.get(0);
            case "PASSWORD":
                return args.get(1);
            case "ROLE":
                return args.get(2);
            case "PATH":
                return args.get(3);
            case "DATE_IN":
                return args.get(4);
            case "DATE_OUT":
                return args.get(5);
            case "VOLUME":
                return args.get(6);
        }
        return null;
    }

    private String getOption(String optionName, CommandLine line) {
        String opt = "";
        try {
            if (line.hasOption(optionName)) {
                opt = line.getOptionValue(optionName);
                return opt;
            }
        } catch (NumberFormatException | NullPointerException e) {
            return opt;
        }
        return opt;
    }

    public static boolean isCheckArg(String arg, CommLineArgs arguments){
        return !Objects.equals(arguments.getArg(arg), "");
    }
}
