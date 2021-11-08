package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2.1.5. Map.
 * 8. Реализовать собственную структуру данных - HashMap[#1008 #127228]
 * Основной класс.
 *
 * @param <K> Key.
 * @param <V> Value.
 * @author Dmitry
 * @version 1
 * @since 08.11.2021.
 */
public class SimpleMap<K, V> implements Map<K, V> {
    /**
     * Степень заполнения таблицы. 0.75 по умолчанию.
     */
    private static final float LOAD_FACTOR = 0.75f;
    /**
     * Размер таблицы.
     */
    private int capacity = 8;
    /**
     * Размер таблицы.
     */
    private int count = 0;
    /**
     * признак модификации.
     */
    private int modCount = 0;
    /**
     * Массив hash таблицы.
     */
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    /**
     * Метод добавляет новый элемент в таблице.
     *
     * @param key   Key.
     * @param value Value.
     * @return boolean.
     */
    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            table[index].key = key;
            table[index].value = value;
            result = true;
        }
        count++;
        modCount++;
        if (((float) count / capacity) >= 0.75) {
            expand();
        }
        return result;
    }

    /**
     * Метод реализует hash функцию.
     *
     * @param hashCode HashCode.
     * @return Int result.
     */
    private int hash(int hashCode) {
        int h = hashCode;
        return (hashCode == 0) ? 0 : h ^ (h >>> capacity);
    }

    /**
     * Вычисление индекса бакета.
     *
     * @param hash Hash function.
     * @return Index table.
     */
    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    /**
     * Расширение размера table.
     */
    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        capacity = capacity * 2;
        table = new MapEntry[capacity];
        int oldCount = count;
        count = 0;
        for (int i = 0; i < oldCount; i++) {
            put(oldTable[i].key, oldTable[i].value);
        }
    }

    /**
     * Возвращает значение по ключу.
     *
     * @param key Key.
     * @return Value.
     */
    @Override
    public V get(K key) {
        V result = null;
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            result = table[index].value;
        }
        return result;
    }

    /**
     * Удаление значения по ключу.
     *
     * @param key Key.
     * @return Boolean.
     */
    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            table[index] = null;
            result = true;
        }
        count--;
        modCount++;
        return result;
    }

    /**
     * Итератор.
     *
     * @return Key.
     */
    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            int expectedCount = modCount;
            int step = 0;

            @Override
            public boolean hasNext() {
                return step < count;
            }

            @Override
            public K next() {
                if (expectedCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[step++].key;
            }
        };
    }

    /**
     * Модель данных MapEntry.
     *
     * @param <K> Key.
     * @param <V> Value.
     */
    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
