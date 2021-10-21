package ru.job4j.list;

/**
 * 2.1.3.List
 * 1. Динамический список на массиве. [#158 #127218]
 * Интерфейс
 *
 * @param <T> type
 * @author Dima_Nout
 * @version 1
 * @since 21.10.2021
 */
public interface List<T> extends Iterable<T> {
    void add(T value);

    T set(int index, T newValue);

    T remove(int index);

    T get(int index);

    int size();
}
