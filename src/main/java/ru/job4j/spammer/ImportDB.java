package ru.job4j.spammer;

import ru.job4j.serialization.json.A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

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
     * Загрузка списка спамеров из файла МОЙ ВАРИАНТА.
     *
     * @return List
     */
    public List<User> loadMy() {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().map(line -> line.split("\\s*[;]\\s*"))
                    .filter(spammer -> spammer.length == 2
                            && !spammer[0].equals("")
                            && !spammer[1].equals(""))
                    .forEach(spammer -> users.add(new User(spammer[0].strip(), spammer[1].strip())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (users.size() == 0) {
            throw new IllegalArgumentException("File \"" + dump + "\" is invalid ");
        }
        return users;
    }

    /**
     * Загрузка списка спамеров из файла
     *
     * @return List
     */
    public List<User> load() {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            for (String line = rd.readLine(); line != null; line = rd.readLine()) {
                String[] lines = line.split("\\s*[;]\\s*");
                if (!(lines.length == 2) || (lines[0].equals("") || lines[1].equals(""))) {
                    throw new IllegalArgumentException("File \"" + dump + "\" is invalid");
                }
                users.add(new User(lines[0].strip(), lines[1].strip()));
            }
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
                    System.out.println("Save spammer->" + user.name + ";" + user.email);
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