package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2.1.3. List
 * 3. Удалить head в односвязном списке. [#51424 #127220]
 *
 * @param <T> type.
 * @author Dima_Nout
 * @version 1
 * @since 25.10.2021
 */
public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int modCount;
    private int size;

    /**
     * Добавление нового элемента в конец списка.
     *
     * @param value Новый элемент
     */
    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = getTile();
        tail.next = node;
        size++;
        modCount++;
    }

    /**
     * Добавляет новый элемент в начало списка.
     *
     * @param value Новое значение.
     */
    public void addFirst(T value) {
        head = new Node<>(value, head);
        size++;
        modCount++;
    }

    /**
     * Удаление первого элемента в односвязном списке.
     */
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> value = head;
        head = head.next;
        value.next = null;
        size--;
        modCount++;
        return value.value;
    }

    /**
     * Удаление последнего элемента в односвязном списке.
     */
    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tile = head;
        T value = tile.value;
        if (head.next != null) {
            while (tile.next.next != null) {
                tile = tile.next;
            }
            value = tile.next.value;
            tile.next = null;
        }
        if (head.next == null) {
            head = null;
        }
        size--;
        modCount++;
        return value;

    }

    /**
     * Размер коллекции.
     *
     * @return size.
     */
    public int size() {
        return size;
    }

    /**
     * Возвращает последний элемент в списке.
     *
     * @return tile
     */
    private Node<T> getTile() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tile = head;
        while (tile.next != null) {
            tile = tile.next;
        }
        return tile;
    }

    /**
     * Переворачивает односвязный список.
     *
     * @return result.
     */
    public boolean revert() {
        boolean result = false;
        return result;
    }

    /**
     * Итератор
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    /**
     * Приватный класс описывает узел Node
     * для односвязного списка.
     *
     * @param <T> type.
     */
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
