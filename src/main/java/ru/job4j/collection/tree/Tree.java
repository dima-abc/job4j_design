package ru.job4j.collection.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 2.1.6. Tree
 * 1. Создать элементарную структуру дерева [#1711 #127246]
 * Interface
 *
 * @param <E> Element
 * @author Dmitry
 * @version 1
 * @since 10.11.2021
 */
public interface Tree<E> {

    /**
     * Находить узел по значению parent
     * и добавлять в него дочерний узел со значением child
     *
     * @param parent Parent value
     * @param child  Child value
     * @return Boolean
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    boolean isBinary();

    /**
     * Описывает узел дерева.
     * Узел содержит хранимое значение
     * и ссылки на дочерние узлы
     *
     * @param <E> Element.
     */
    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}
