package ru.job4j.generics;

/**
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base> [#157 #127243]
 * Базовой модели Base. Все модели наследуются от нее.
 *
 * @author Dmitry
 * @version 1
 * @since 19.10.2021
 */
public abstract class Base {
    private final String id;

    public Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
