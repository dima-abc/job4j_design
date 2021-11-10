package ru.job4j.collection.set;

import ru.job4j.collection.listarray.SimpleArrayList;

import java.util.Iterator;

/**
 * 2.1.4. Set
 * 1. Реализовать коллекцию Set на массиве [#996 #127245].
 * Base class.
 *
 * @param <T> Type.
 * @author Dmitry
 * @version 1
 * @since 01.11.2021.
 */
public class SimpleSet<T> implements Set<T> {
    /**
     * Хранилище данных.
     */
    private SimpleArrayList<T> set = new SimpleArrayList<>();

    /**
     * Добавление данных в коллекцию.
     * Дубликаты не добавляются.
     *
     * @param value Value.
     * @return boolean.
     */
    @Override
    public boolean add(T value) {
        boolean result = false;
        if (!contains(value)) {
            set.add(value);
            result = true;
        }

        return result;
    }

    /**
     * Поиск значения в коллекции.
     *
     * @param value Value.
     * @return boolean.
     */
    @Override
    public boolean contains(T value) {
        boolean result = false;
        for (T s : set) {
            if (s == null || s.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Итератор.
     *
     * @return iterator.next.
     */
    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
