package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

/**
 * 2.5.0. TDD
 * 1. Принципы Kiss, Dry и Yagni [#238813]
 * Класс для поиска максимального и минимального элемента по критерию
 * java.util.Comparator.
 *
 * @author Dima_Nout
 * @since 29.01.2022
 */
public class MaxMin {

    /**
     * Поиск мах
     *
     * @param value      List
     * @param comparator Comparator
     * @param <T>        type
     * @return max.
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T max = value.get(0);
        for (T element : value) {
            if (comparator.compare(max, element) < 0) {
                max = element;
            }
        }
        return max;
    }

    /**
     * Поиск min
     *
     * @param value      List
     * @param comparator Comparator
     * @param <T>        type
     * @return min
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }
}
