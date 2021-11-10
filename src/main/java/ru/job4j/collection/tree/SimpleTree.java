package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * 2.1.6. Tree
 * 1. Создать элементарную структуру дерева [#1711 #127246]
 * Основной класс.
 *
 * @param <E> Element
 * @author Dmitry
 * @version 1
 * @since 10.11.2021
 */
public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * Находить узел по значению parent
     * и добавлять в него дочерний узел со значением child
     *
     * @param parent Parent value
     * @param child  Child value
     * @return Boolean
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> first = findBy(parent);
        if (first.isPresent() && findBy(child).isEmpty()) {
            first.get().children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод использует алгоритм обхода в ширину.
     * Поиск элемента в дереве.
     *
     * @param value Value
     * @return Optional Node.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
