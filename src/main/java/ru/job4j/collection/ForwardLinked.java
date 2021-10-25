package ru.job4j.collection;

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

    /**
     * Добавление нового элемента в конец списка.
     *
     * @param value Новый элемент
     */
    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * Добавляет новый элемент в начало списка.
     *
     * @param value Новое значение.
     */
    public void addFirst(T value) {
        head = new Node<>(value, head);
    }

    /**
     * Удаление первого элемента в односвязном списке.
     */
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head = head.next;
        return value;
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

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
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
