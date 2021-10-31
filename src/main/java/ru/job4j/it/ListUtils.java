package ru.job4j.it;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * 2.1.3.List
 * 7.ListIterator[#350217]
 *
 * @author Dima_Nout
 * @version 1
 * @since 31.10.2021
 */
public class ListUtils {
    /**
     * Вставляет элемент до индекса.
     *
     * @param list  List.
     * @param index Index.
     * @param value Value.
     * @param <T>   Type.
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /**
     * Вставляет элемент после индекса.
     *
     * @param list  List.
     * @param index Index.
     * @param value Value.
     * @param <T>   Type.
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.next();
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /**
     * Удаляет все элементы которые удовлетворяют предикату.
     * Запрещено использовать метод List.removeIf.
     *
     * @param list   List.
     * @param filter Predicate.
     * @param <T>    Type.
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.remove();
            }
        }
    }

    /**
     * Заменяет все элементы которые удовлетворяют предикату.
     *
     * @param list   List.
     * @param filter Predicate.
     * @param value  Value
     * @param <T>    Type.
     */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.set(value);
            }
        }
    }

    /**
     * Удаляет из списка те элементы, которые есть в elements.
     * Запрещено использовать метод List.removeAll().
     *
     * @param list List
     * @param elements List
     * @param <T> Type
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T value = i.next();
            for (T element : elements) {
                if (value.equals(element)) {
                    i.remove();
                    break;
                }
            }
        }
    }
}
