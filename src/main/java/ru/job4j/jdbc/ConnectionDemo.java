package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;

/**
 * 2.3.5. JDBC
 * 0. JDBC [#6863]
 *
 * @author Dmitry
 * @since 23.12.2021
 */
public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Config config = Config.of("./src/main/resources/jdbc/app.properties");
        String url = config.get("url");
        String login = config.get("login");
        String password = config.get("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDatabaseProductVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
