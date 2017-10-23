package Library_classes;

import org.apache.commons.cli.*;

public class Autentification
{
    public final static String Login = "Login";
    public final static String Password = "Password";

    private Options options;
    private CommandLine line;

    public Autentification()
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

    public void Parse(String[] args) throws Exception
    {
        CommandLineParser parser = new DefaultParser();
        line = parser.parse(options, args);
        if (line.hasOption("help"))
        {
            throw new Exception("Print help and exit");
        }
    }

    private String getOption(String optionName)
    {
        String val = "";
        if( line.hasOption( optionName ) )
        {
            try
            {
                val = line.getOptionValue( optionName );
                //val = val &gt; 0 ? val : -val;
            }
            catch (NumberFormatException e)
            {
            }
            return val;
        }
        else
        {
            return val;
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

    public void printHelp()
    {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Goodline application", "Прочитайте инструкцию к программе",
                options, "Разработано: Bullet1395");
    }
}

