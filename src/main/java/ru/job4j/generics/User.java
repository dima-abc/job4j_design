package ru.job4j.generics;

/**
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base> [#157 #127243]
 * Модель данных Store.
 *
 * @author Dmitry
 * @version 1
 * @since 19.10.2021
 */
public class User extends Base {
    private String name;

    public User(String name, String id) {
        super(id);
        this.name = name;
    }
}
