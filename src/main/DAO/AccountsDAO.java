package main.DAO;

import main.domain.Accounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountsDAO {
    private static final Logger logger = LogManager.getLogger(AccountsDAO.class.getName());

    private static final String sqlInsertAccounts = "INSERT INTO ACCOUNTS(LOGIN, DATE_IN, DATE_OUT, VOLUME)" + "VALUES (?, ?, ?, ?)";

    private Connection connection;

    public AccountsDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAccountsUser(Accounts accounting) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertAccounts);
            preparedStatement.setString(1, accounting.getLogin());
            preparedStatement.setDate(2, Date.valueOf(accounting.getDateIn()));
            preparedStatement.setDate(3, Date.valueOf(accounting.getDateOut()));
            preparedStatement.setInt(4, Integer.parseInt(String.valueOf(accounting.getVolume())));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("Ошибка подключения к БД.", e);
        }
    }
}
