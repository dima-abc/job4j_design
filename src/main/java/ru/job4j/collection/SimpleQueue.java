package ru.job4j.collection;

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
        if (in.size() == 0 && out.size() == 0) {
            throw new NoSuchElementException();
        }
        if (out.size() == 0) {
            upend(in, out);
        }
        return out.pop();
    }

    /**
     * Помещает значение в конец списка.
     *
     * @param value новое задание.
     */
    public void push(T value) {
        in.push(value);
    }

    /**
     * Перекладывает данные из коллекции в коллекцию.
     *
     * @param in  из.
     * @param out в.
     */
    private void upend(SimpleStack<T> in, SimpleStack<T> out) {
        int length = in.size();
        for (int i = 0; i < length; i++) {
            out.push(in.pop());
        }
    }
}
