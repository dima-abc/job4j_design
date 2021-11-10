package ru.job4j.collection.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2.1.1. Iterator
 * 5.1.2. Создать итератор четные числа[#150#127234]
 *
 * @author Dima_Nout
 * @version 1
 * @since 17.10.2021
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index < data.length
                && data[index] % 2 != 0) {
            index++;
        }
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}
