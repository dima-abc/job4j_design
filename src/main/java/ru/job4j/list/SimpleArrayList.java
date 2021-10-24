package ru.job4j.list;

import java.util.*;

/**
 * 2.1.3. List
 * 1. Динамический список на массиве. [#158 #127218]
 * Основной класс
 *
 * @param <T> type
 * @author Dima_Nout
 * @version 1
 * @since 21.10.2021
 */
public class SimpleArrayList<T> implements List<T> {
    private T[] container;
    private int size;
    private int modCount;

    /**
     * Конструктор по умолчанию,
     * создает список емкостью 10.
     */
    public SimpleArrayList() {
        this.container = (T[]) new Object[10];
    }

    /**
     * Конструктор с параметром.
     *
     * @param capacity размер списка.
     */
    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    /**
     * Добавление элемента в список.
     *
     * @param value новый элемент.
     */
    @Override
    public void add(T value) {
        if (size == this.container.length) {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
        }
        this.container[size++] = value;
        modCount++;
    }

    /**
     * Изменяет элемент в списке.
     *
     * @param index    индекс изменения элемента.
     * @param newValue новое значение.
     * @return старое значение которое хранилось в index.
     */
    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T value = this.container[index];
        this.container[index] = newValue;
        return value;
    }

    /**
     * Удаление элемента списка по индексу.
     *
     * @param index индекс в списке.
     * @return удаленный элемент.
     */
    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T value = this.container[index];
        System.arraycopy(this.container, index + 1,
                this.container, index, size - 1 - index);
        this.container[size - 1] = null;
        size--;
        this.modCount++;
        return value;
    }

    /**
     * Возвращает элемент массива по индексу.
     *
     * @param index индекс элемента.
     * @return элемент массива.
     */
    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return this.container[index];
    }

    /**
     * Размер спика.
     *
     * @return this.size.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Итератор спика.
     *
     * @return элемент списка.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;
            int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }
        };
    }
}
