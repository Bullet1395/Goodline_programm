package bin.DAO;

import bin.domain.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
    private static final Logger logger = LogManager.getLogger(UsersDAO.class.getName());

    private static final String sqlSelectUsers = "SELECT * FROM USERS WHERE LOGIN = ?";

    private Connection connection;

    public UsersDAO(Connection connection) {
        this.connection = connection;
    }

    public Users searchUser(String login) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement(sqlSelectUsers);
            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Users(
                        resultSet.getString("LOGIN"),
                        resultSet.getString("HASH_PASSWORD"),
                        resultSet.getString("SALT"));
            } else {
                logger.trace("Данных не найдено.");
            }

        } catch (SQLException e) {
            logger.error("Ошибка подключения к БД.", e);
        }
        return null;
    }
}
