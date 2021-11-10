package ru.job4j.collection.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2.1.1 Iterator
 * 1. Что такое итератор.
 * Задание. Итератор должен отдавать элементы массива в обратном порядке.
 *
 * @author Dima_Nout
 * @version 1
 * @since 15.10.2021
 */
public class BackwardArrayIt implements Iterator<Integer> {
    private int[] data;
    private int point;

    public BackwardArrayIt(int[] data) {
        this.data = data;
        point = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}
