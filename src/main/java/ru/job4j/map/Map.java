package ru.job4j.map;

/**
 * 2.1.5. Map.
 * 8. Реализовать собственную структуру данных - HashMap[#1008 #127228]
 * Интерфейс.
 *
 * @param <K> Key.
 * @param <V> Value.
 * @author Dmitry
 * @version 1
 * @since 08.11.2021
 */
public interface Map<K, V> extends Iterable<K> {
    boolean put(K key, V value);

    V get(K key);

    boolean remove(K key);
}
