package ru.job4j.collection;

/**
 * 2.1.3.List
 * 5. Очередь на двух стеках[#160 #127216]
 *
 * @param <T>
 * @author Dmitry
 * @version 1
 * @since 26.10.2021
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * Возвращает первое значение и удалять его из коллекции.
     *
     * @return удалённый элемент
     */
    public T poll() {

            return null;
    }

    /**
     * Помещает значение в конец списка.
     *
     * @param value новое задание.
     */
    public void push(T value) {
        in.push(value);
    }
}
