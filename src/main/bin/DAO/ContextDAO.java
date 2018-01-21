package main.bin.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContextDAO {
    private String dbDriver;
    private String dbUrl;
    private String dbUserName;
    private String dbPassword;

    public String getDbDriver() {
        return dbDriver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
    }

    public void closeConnection() throws SQLException, ClassNotFoundException {
        DriverManager.getConnection(dbUrl, dbUserName, dbPassword).close();
    }

    public ContextDAO withDataBaseDriver(String dataBaseDriver) {
        this.dbDriver = dataBaseDriver;
        return this;
    }

    public ContextDAO withDataBaseUrl(String dataBaseUrl) {
        this.dbUrl = dataBaseUrl;
        return this;
    }

    public ContextDAO withDataBaseUserName(String dataBaseUserName) {
        this.dbUserName = dataBaseUserName;
        return this;
    }

    public void withDataBasePassword(String dataBasePassword) {
        this.dbPassword = dataBasePassword;
    }
}
