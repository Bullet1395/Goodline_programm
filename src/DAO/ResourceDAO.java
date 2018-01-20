package DAO;

import domain.Resources;
import domain.enums.Roles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResourceDAO {
    private static final Logger logger = LogManager.getLogger(ResourceDAO.class.getName());

    /**
     * Проверяет полученный путь ресурса из параметров(pathResourceFromArg) с записью в таблице ресурсов(pathResource)
     * Если количество символов pathResourceFromArg >= pathResource тогда идет сравнение путей.
     * у p2 остается столько символов сколько у p1, это позволяет реализоавть доступ ко всем внутренним папкам
     * с такой же ролью. Проверка на роль была уже пройдена другим методом.
     * т.е. есть запись в таблице C.R.RR, а передалась C.R.RR.T.G.H. т.к. у нас есть доступ к RR,
     * а все остальные это вложенные
     * ресурсы то к ним мы тоже получаем доступ.
     * Если символов меньше, чем в записи таблицы, выходим из метода и проверяем следующую запись
     * с таким именем пользователя
     *
     * @param pathFromArg     путь переданный из аргументов
     * @param resourceFromBD проверяемый ресурс(запись из таблицы)
     * @return true или false
     */
    private boolean isValidPath(String pathFromArg, String resourceFromBD) {
        if (pathFromArg.length() >= resourceFromBD.length()) {
            String pathResource = pathFromArg.substring(0, resourceFromBD.length());
            return resourceFromBD.equals((pathResource));
        }
        return false;
    }

    private Connection connection;

    public ResourceDAO(Connection connection) {
        this.connection = connection;
    }

    private final String sqlSelectResource = "SELECT * FROM RESOURCES WHERE" +
            "(RESOURCES.LOGIN LIKE ?) AND " +
            "(RESOURCES.ROLE LIKE ?)";

    public Resources getResource(String resource, String role, String login) throws SQLException {
        logger.trace("Подготовка запроса: [{}]", sqlSelectResource);

        try {
            PreparedStatement statement = connection.prepareStatement(sqlSelectResource);
            statement.setString(1, login);
            statement.setString(2, role);
            logger.trace("Выполнение запроса к БД: [{}]", statement);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (isValidPath(resource, resultSet.getString("RESOURCE"))) {
                    return new Resources(
                            resultSet.getString("LOGIN"),
                            Roles.valueOf(resultSet.getString("ROLE")),
                            resultSet.getString("RESOURCE"));
                }
            }
        } catch (SQLException e) {
            logger.error("Ошибка подключения к БД.", e);
            return null;
        }
        return null;
    }
}
