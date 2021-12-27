package ru.job4j.spammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 2.3.5. JDBC
 * 0.2. PrepareStatement [#379307]
 * задание.
 * Создать базу данных для спамеров из файла со списком Name;Email.
 *
 * @author Dmitry
 * @since 28.12.2021
 */
public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    /**
     * Загрузка списка спамеров из файла.
     *
     * @return List
     */
    public List<User> load() {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .map(l -> l.split(";"))
                    .forEach(l -> users.add(new User(l[0], l[1])));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Запись списка спамеров в базу данных spammer.
     *
     * @param users List(User).
     * @throws ClassNotFoundException exception.
     */
    public void save(List<User> users) throws ClassNotFoundException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement(
                        "insert into users(name, email) values(?,?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Модель данных User
     */
    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        ClassLoader loader = ImportDB.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("spammer/app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./data/dump.txt");
        db.save(db.load());
    }
}