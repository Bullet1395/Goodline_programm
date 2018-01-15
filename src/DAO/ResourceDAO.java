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

    private Connection connection;

    public ResourceDAO(Connection connection) {
        this.connection = connection;
    }

    private final String sqlSelectResource = "SELECT * FROM RESOURCES WHERE" +
            "(RESOURCES.LOGIN LIKE ?) AND " +
            "(RESOURCES.RESOURCE LIKE ?) AND " +
            "(RESOURCES.ROLE LIKE ?)";

    public Resources getResource(String resource, String role, String login) throws SQLException {
        String findResource = "";

        try {
            String[] arrayOfResource = resource.split("\\.");

            for (String res : arrayOfResource) {
                findResource += res;
                PreparedStatement statement = connection.prepareStatement(sqlSelectResource);
                statement.setString(1, login);
                statement.setString(2, findResource);
                statement.setString(3, role);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    return new Resources(
                            resultSet.getString("LOGIN"),
                            Roles.valueOf(resultSet.getString("ROLE")),
                            resultSet.getString("RESOURCE"));
                }

                findResource += ".";
            }

        } catch (SQLException e) {
            logger.error("Ошибка подключения к БД.", e);
            return null;
        }
        return null;
    }

}
