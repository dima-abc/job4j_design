package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;
import java.util.StringJoiner;

/**
 * 2.3.5. JDBC
 * 0. JDBC [#6863]
 * 0.1. Statement [#379306]
 *
 * @author Dmitry
 * @since 23.12.2021
 */
public class ConnectionDemo {
    /**
     * Создание подключение к базе данных.
     *
     * @return Connection.
     * @throws Exception exception.
     */
    private static Connection getConnection() throws Exception {
        Config config = Config.of("./src/main/resources/jdbc/idea_db.properties");
        String url = config.get("url");
        String login = config.get("login");
        String password = config.get("password");
        String driver = config.get("driver");
        Class.forName(driver);
        return DriverManager.getConnection(url, login, password);
    }

    /**
     * Вывод схемы таблицы, столбцы и их типы.
     *
     * @param connection Connection
     * @param tableName  TableName
     * @return String
     * @throws Exception exception
     */
    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i)));
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) throws Exception {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists demo_table(%s,%s);",
                        "id serial primary key",
                        "name varchar(255)"
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "demo_table"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Config config = Config.of("./src/main/resources/jdbc/app.properties");
        String url = config.get("url");
        String login = config.get("login");
        String password = config.get("password");
        String driver = config.get("driver");
        Class.forName(driver);
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
