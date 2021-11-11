package ru.job4j.collection.question;

import java.util.Objects;

/**
 * Collection
 * 2.1.7. Контрольные вопросы
 * 2. Статистика по коллекции. [#45889 #127233]
 * Модель User.
 *
 * @author Dmitry
 * @version 1
 * @since 11.11.2021
 */
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
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
        return id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
