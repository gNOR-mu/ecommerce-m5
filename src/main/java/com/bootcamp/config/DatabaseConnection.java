package com.bootcamp.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private String url;
    private String user;
    private String password;
    private String driver;

    private DatabaseConnection() {
        loadProperties();
        loadDriver();
    }

    private void loadProperties() {
        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("database.properties")
        ) {
            if (input == null) {
                throw new RuntimeException("No se encontró el archivo database.properties");
            }

            Properties props = new Properties();
            props.load(input);

            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");
            driver = props.getProperty("db.driver");

        } catch (IOException e) {
            throw new RuntimeException("Error cargando database.properties", e);
        }
    }

    private void loadDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se pudo cargar el driver" + driver, e);
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
