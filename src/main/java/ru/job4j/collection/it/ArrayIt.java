package ru.job4j.collection.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2.1.1 Iterator
 * 1. Что такое итератор.help
 *
 * @author Dima_Nout
 * @version 1
 * @since 15.10.2021
 */
public class ArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public ArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
