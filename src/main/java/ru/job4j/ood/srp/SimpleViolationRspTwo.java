package ru.job4j.ood.srp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 2.5.1. SRP
 * 0. Принцип единственной ответственности [#4913]
 * Пример 2. Класс создает и инициализирует объект,
 * при создании соединения с базой данных.
 * Решение принимать Properties в конструкторе и работать с ним.
 *
 * @author Dima_Nout
 * @since 01.02.2022
 */
public class SimpleViolationRspTwo {
    public Connection initConnect(String file) throws SQLException {
        Properties properties = new Properties();
        ClassLoader loader = SimpleViolationRspTwo.class.getClassLoader();
        try (InputStream input = loader.getResourceAsStream(file)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password"));
    }
}
