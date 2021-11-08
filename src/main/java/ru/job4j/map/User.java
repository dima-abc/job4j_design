package ru.job4j.map;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 * 2.1.5. Map
 * 1. Создать модель User [#999 #127223]
 *
 * @author Dmitry
 * @version 1
 * @since 02.11.2021
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;
    private DateFormat formatter = new SimpleDateFormat("dd:MM:yyyy");

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" + "name='"
                + name + '\''
                + ", children=" + children
                + ", birthday=" + formatter.format(birthday.getTime()) + '}';
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
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday)
                && Objects.equals(formatter, user.formatter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday, formatter);
    }
}
