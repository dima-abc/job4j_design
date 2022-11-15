package ru.job4j.gc.leak;

import ru.job4j.gc.leak.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 2. Джуниор
 * 2.4. Garbage Collection
 * 2.4.3. Профилирование приложения
 * 2. Найти утечку памяти. [#504882]
 * Генератор пользователей.
 * При создании UserGenerator мы заполним списки с именами, фамилиями, отчествами,
 * а при вызове generate зачищаем список users
 * и будем брать случайные значения из списков.
 * Таким образом каждый раз создаем 1000 пользователей.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.11.2022
 */
public class UserGenerator implements Generate {
    public static final String PATH_NAMES = "src/main/java/ru/job4j/gc/leak/files/names.txt";
    public static final String PATH_SURNAMES = "src/main/java/ru/job4j/gc/leak/files/surnames.txt";
    public static final String PATH_PATRONS = "src/main/java/ru/job4j/gc/leak/files/patr.txt";

    public static final String SEPARATOR = " ";
    public static final Integer NEW_USERS = 1000;

    public List<String> names;
    public List<String> surnames;
    public List<String> patrons;
    private final List<User> users = new ArrayList<>();
    private final Random random;

    public UserGenerator(Random random) {
        this.random = random;
        readAll();
    }

    @Override
    public void generate() {
        users.clear();
        for (int i = 0; i < NEW_USERS; i++) {
            String fio = String.join(SEPARATOR,
                    surnames.get(random.nextInt(surnames.size())),
                    names.get(random.nextInt(names.size())),
                    patrons.get(random.nextInt(patrons.size())));
            users.add(new User(fio));
        }
    }

    private void readAll() {
        try {
            this.names = read(PATH_NAMES);
            this.surnames = read(PATH_SURNAMES);
            this.patrons = read(PATH_PATRONS);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public User randomUser() {
        return users.get(random.nextInt(users.size()));
    }
}
