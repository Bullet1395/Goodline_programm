package bin.service;

import bin.domain.Accounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Accounting {
    private static final Logger logger = LogManager.getLogger(Authorization.class.getName());

    private static LocalDate isDateValid(String date){
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException | NullPointerException e) {
            return null;
        }
    }

    private static Integer isVolumeValid(String volume){
        try {
            return Integer.parseInt(volume);
        } catch (DateTimeParseException | NullPointerException  | NumberFormatException e) {
            return null;
        }
    }

    /**
     * Метод создания аккаунтинга для добавления в бд
     *
     * @param account - объект, который будет помещаться в БД
     * @param args - входные параметры
     */
    private void addAccounting(Accounts account, CommLineArgs args) throws SQLException {
        account.setLogin(args.getLogin());
        account.setDateIn(LocalDate.parse(args.getDateIn()));
        account.setDateOut(LocalDate.parse(args.getDateOut()));
        account.setVolume(Integer.parseInt(args.getVolume()));
    }

    /**
     * Проверка аккаунтинга
     *
     * @param accounts - объект аккауниг
     * @param args  - входные данные
     * @param isAuthorization - проверка авторизации
     * @return системная ошибка(код)
     */
    public boolean isAccounting(Accounts accounts, CommLineArgs args, boolean isAuthorization)
            throws SQLException {
        if (isAuthorization && args.getDateIn() != null) {
            if (isDateValid(args.getDateIn()) == null
                    || isDateValid(args.getDateOut()) == null
                    || isVolumeValid(args.getVolume()) == null) {
                logger.error("Некорректная дата или объем");
                System.exit(5);
            }
            addAccounting(accounts, args);
            return true;
        }
        logger.trace("Аккаунтинг не пройден. Нет аргументов");
        return false;
    }
}
