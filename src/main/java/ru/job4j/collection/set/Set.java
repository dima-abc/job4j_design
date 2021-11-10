package ru.job4j.collection.set;

/**
 * 2.1.4. Set
 * 1. Реализовать коллекцию Set на массиве [#996 #127245].
 * Interface.
 *
 * @param <T> Type.
 * @author Dmitry.
 * @version 1.
 * @since 01.11.2021.
 */
public interface Set<T> extends Iterable<T> {
    boolean add(T value);

    boolean contains(T value);
}