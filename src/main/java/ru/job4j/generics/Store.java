package ru.job4j.generics;

/**
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base> [#157 #127243]
 * Интерфейс для описания контейнеров.
 *
 * @author Dmitry
 * @version 1
 * @since 19.10.2021
 */
public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
