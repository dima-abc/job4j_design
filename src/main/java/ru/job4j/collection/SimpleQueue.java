package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        if (out.size() == 0) {
            throw new NoSuchElementException();
        }
        revert(out, in);
        T result = in.pop();
        revert(in, out);
        return result;
    }

    /**
     * Помещает значение в конец списка.
     *
     * @param value новое задание.
     */
    public void push(T value) {
        in.push(value);
        revert(in, out);
    }

    private void revert(SimpleStack<T> in, SimpleStack<T> out) {
        for (int i = 0; i < in.size(); i++) {
            out.push(in.pop());
        }
    }
}
