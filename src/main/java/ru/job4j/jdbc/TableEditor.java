package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * 2.3.5.JDBC
 * 0.1. Statement [#379306]
 * задача.
 *
 * @author Dmitry
 * @since 27.12.2021
 */
public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;
    private String fileProperties;

    /**
     * Конструктор принимает новый объект Properties,
     * и имя файла *.properties,
     * файл.properties должен находится в каталоге resources.
     *
     * @param properties     new Properties.
     * @param fileProperties resources/FILE.properties.
     */
    public TableEditor(Properties properties, String fileProperties) throws Exception {
        this.properties = properties;
        this.fileProperties = fileProperties;
        loadProperties();
        initConnection();
    }

    /**
     * Загружает параметры из FILE.properties в Properties.class.
     */
    private void loadProperties() {
        ClassLoader loader = TableEditor.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream(this.fileProperties)) {
            this.properties.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Создание Connection.
     */
    private void initConnection() throws Exception {
        String driver = this.properties.getProperty("driver");
        String url = this.properties.getProperty("url");
        String lorin = this.properties.getProperty("login");
        String password = this.properties.getProperty("password");
        Class.forName(driver);
        this.connection = DriverManager.getConnection(url, lorin, password);
    }

    /**
     * Создание statement для выполнения любого запросы.
     *
     * @param sql String.
     */
    private void getStatement(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Создает пустую таблицу без столбцов с указанным именем;
     *
     * @param tableName String.
     */
    public void createTable(String tableName) {
        String sql = String.format(
                "CREATE TABLE IF NOT EXISTS %s();",
                tableName
        );
        getStatement(sql);
    }

    /**
     * Удаляет таблицу по указанному имени;
     *
     * @param tableName String.
     */
    public void dropTable(String tableName) {
        String sql = String.format(
                "DROP TABLE %s;",
                tableName
        );
        getStatement(sql);
    }

    /**
     * Добавляет столбец в таблицу;
     *
     * @param tableName  String.
     * @param columnName String.
     * @param type       String.
     */
    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format(
                "ALTER TABLE %s ADD COLUMN %s %s;",
                tableName, columnName, type
        );
        getStatement(sql);
    }

    /**
     * Удаляет столбец из таблицы.
     *
     * @param tableName String.
     * @param column    String.
     */
    public void dropColumn(String tableName, String column) {
        String sql = String.format(
                "ALTER TABLE %s DROP COLUMN %s;",
                tableName, column
        );
        getStatement(sql);
    }

    /**
     * Переименовывает столбец.
     *
     * @param table         String.
     * @param columnName    String.
     * @param newColumnName String.
     */
    public void renameColumn(String table, String columnName, String newColumnName) {
        String sql = String.format(
                "ALTER TABLE %s RENAME COLUMN %s TO %s;",
                table, columnName, newColumnName
        );
        getStatement(sql);
    }

    /**
     * Возвращает созданную таблицу из базы данных.
     *
     * @param connection Connection.
     * @param tableName  String.
     * @return String.
     * @throws Exception exception.
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
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    /**
     * Явное закрытие соединение с базой.
     *
     * @throws Exception exception
     */
    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
