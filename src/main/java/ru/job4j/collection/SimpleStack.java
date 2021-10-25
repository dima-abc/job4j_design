package ru.job4j.collection;

/**
 * 2.1.3. List
 * 4. Используя контейнер на базе связанного списка
 * создать контейнер Stack[#71474#127214]
 * Stack LiFo.
 *
 * @param <T> type.
 * @author Dima_Nout
 * @version 1
 * @since 25.10.2021.
 */
public class SimpleStack<T> {
    /**
     * База Stack односвязный список.
     */
    private ForwardLinked<T> linked = new ForwardLinked<>();

    /**
     * Возвращает значение и удаляет его из списка.
     * Удаляет последний элемент в списке.
     *
     * @return T type.
     */
    public T pop() {
        return linked.deleteFirst();
    }

    /**
     * Помещает значение в коллекцию.
     * Добавляет элемент в конец списка.
     *
     * @param value новое значение.
     */
    public void push(T value) {
        linked.addFirst(value);
    }
}
