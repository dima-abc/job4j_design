package ru.job4j.map;

import java.util.Calendar;

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

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
