package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 2.1.3. List
 * 2. Создать контейнер на базе связанного списка [#159 #127219]
 * Основной класс.
 *
 * @param <E> element.
 * @author Dima_Nout
 * @version 1
 * @since 24.10.2021
 */
public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;

    /**
     * Добавление нового элемента в конец списка.
     *
     * @param value new Element.
     */
    @Override
    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * Возвращает элемент по индексу.
     *
     * @param index индекс необходимого элемента.
     * @return найденный элемент.
     */
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> value = first;
        for (int i = 0; i < index; i++) {
            value = value.next;
        }
        return value.item;
    }

    /**
     * Размер списка.
     *
     * @return количество элементов в списке.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Итератор.
     *
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private Node<E> value = first;

            @Override
            public boolean hasNext() {
                return value != null;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E item = value.item;
                value = value.next;
                return item;
            }
        };
    }

    /**
     * Приватный вложенный класс описывает
     * элемент узла связанного списка Node.
     *
     * @param <E> element.
     */
    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E elment, Node<E> next) {
            this.item = elment;
            this.prev = prev;
            this.next = next;
        }
    }
}
