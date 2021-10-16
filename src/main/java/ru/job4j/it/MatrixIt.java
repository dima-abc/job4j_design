package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2.1.1. Iterator
 * 5.1.1. Итератор для двухмерного массива int[][][#9539 #127238]
 *
 * @author Dima_Nout
 * @version 1
 * @since 16.10.2021
 */
public class MatrixIt implements Iterator<Integer> {
    private int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (data.length != row && (data[row].length == column || data[row].length == 0)) {
            column = 0;
            row++;
        }
        return row != data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
