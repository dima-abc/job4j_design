package ru.job4j.gc.leak.model;

import java.util.Objects;

/**
 * 2. Джуниор
 * 2.4. Garbage Collection
 * 2.4.3. Профилирование приложения
 * 2. Найти утечку памяти. [#504882]
 * Модель данных User.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.11.2022
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{name='" + name + '\'' + '}';
    }
}
