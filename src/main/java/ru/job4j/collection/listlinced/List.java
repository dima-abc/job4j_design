package ru.job4j.collection.listlinced;

/**
 * 2.1.3. List
 * 2. Создать контейнер на базе связанного списка [#159 #127219]
 * Интерфейс.
 *
 * @param <E> element.
 * @author Dima_Nout
 * @version 1
 * @since 24.10.2021
 */
public interface List<E> extends Iterable<E> {
    void add(E value);

    E get(int index);

    int size();
}
