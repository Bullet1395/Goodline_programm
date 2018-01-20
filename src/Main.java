import DAO.AccountsDAO;
import DAO.ContextDAO;
import DAO.ResourceDAO;
import DAO.UsersDAO;
import domain.Accounts;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import service.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    private static final Logger logger = LogManager.getLogger(UsersDAO.class.getName());

    public static void main(String[] args) {
        logger.trace("Запуск приложения");

        ParseCommLine cmdArgs = new ParseCommLine();
        CommLineArgs arguments = cmdArgs.parse(args);

        if (logger.isTraceEnabled()) {
            logger.log(Level.TRACE, "Аргументы: " + Arrays.toString(args));
        }

        ContextDAO contextDAO = new ContextDAO();

        contextDAO.withDataBaseDriver("org.h2.Driver")
                .withDataBaseUrl("jdbc:h2:file:./src/main/resources/db/Goodline_Programm")
                .withDataBaseUserName("Maxim")
                .withDataBasePassword("123");

        logger.trace("Начало миграции");
        try {
            Flyway flyway = new Flyway();
            flyway.setDataSource(contextDAO.getDbUrl(),
                    contextDAO.getDbUserName(),
                    contextDAO.getDbPassword());
            flyway.migrate();
            logger.trace("Миграция завершена");
        } catch (Exception e) {
            logger.error("Ошибка миграции: " + e.getMessage());
        }

        try (Connection connection = contextDAO.getConnection()) {
            logger.trace("Подключение к базе данных: [{}] установлено", contextDAO.getDbUserName());

            Authentication authentication = new Authentication();
            Authorization authorization = new Authorization();

            UsersDAO userDAO = new UsersDAO(connection);
            ResourceDAO resourceDAO = new ResourceDAO(connection);
            AccountsDAO accountDAO = new AccountsDAO(connection);

            String login = arguments.getLogin();
            String password = arguments.getPassword();
            String resource = arguments.getPath();
            String role = arguments.getRole();

            boolean isAuthentication = false;
            boolean isAuthorization = false;

            logger.trace("Аутентификация");
            if (authentication.isAuthentication(userDAO, login, password)) {
                logger.info("Аутентификация завершена усепшно");
                isAuthentication = true;
            }

            logger.trace("Запускается авторизация");
            if (authorization.isAuthorization(resourceDAO, resource, role, isAuthentication, login)) {
                logger.info("Авторизация прошла успешно");
                isAuthorization = true;
            }

            logger.trace("Запускается аккаунтинг");
            Accounting accounting = new Accounting();
            Accounts account = new Accounts();
            if (accounting.isAccounting(account, arguments, isAuthorization)) {
                accountDAO.addAccountsUser(account);
                logger.info("Аккаунтинг прошел успешно");
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.debug("При подключении к БД произошла ошибка", e);
        }

        System.exit(0);
    }
}
