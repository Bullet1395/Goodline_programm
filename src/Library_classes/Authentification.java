package Library_classes;

import org.apache.commons.cli.*;

public class Authentification
{
    private final static String Login = "Login";
    private final static String Password = "Password";

    private Options options;
    private CommandLine line;

    public Authentification()
    {
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
    }

    private String PrintHelp()
    {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Goodline application", "Прочитайте инструкцию к программе",
                options, "Разработано: Bullet1395");
        return formatter.toString();
    }

    public void Parse(String[] args) throws Exception
    {
        try
        {
            CommandLineParser parser = new DefaultParser();
            line = parser.parse(options, args);
            if (line.hasOption("help"))
            {
                throw new Exception(PrintHelp());
            }
        }
        catch(Exception e)
        {
        }
    }

    private String getOption(String optionName)
    {
        String opt = "";
        if( line.hasOption(optionName))
        {
            try
            {
                opt = line.getOptionValue( optionName );
            }
            catch (NumberFormatException e)
            {
            }
            return opt;
        }
        else
        {
            return opt;
        }
    }

    public String getLogin()
    {
        return getOption(Login);
    }

    public String getPassword()
    {
        return getOption(Password);
    }
}

