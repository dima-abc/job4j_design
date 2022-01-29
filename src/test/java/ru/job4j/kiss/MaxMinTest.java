package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.0. TDD
 * 1. Принципы Kiss, Dry и Yagni [#238813]
 * Класс для поиска максимального и минимального элемента по критерию
 * java.util.Comparator.
 * test.
 *
 * @author Dima_Nout
 * @since 29.01.2022
 */
public class MaxMinTest {

    @Test
    public void whenMaxElementInteger() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        MaxMin maxMin = new MaxMin();
        Integer max = maxMin.max(list, Integer::compare);
        assertThat(max, is(5));
    }

    @Test
    public void whenMaxElementIntegerTwo() {
        List<Integer> list = List.of(10, 11, 2, 3, 5, 8);
        MaxMin maxMin = new MaxMin();
        Integer max = maxMin.max(list, Integer::compare);
        assertThat(max, is(11));
    }

    @Test
    public void whenMinElementInteger() {
        List<Integer> list = List.of(4, 2, 3, 1, 5);
        MaxMin maxMin = new MaxMin();
        Integer min = maxMin.min(list, Integer::compare);
        assertThat(min, is(1));
    }

    @Test
    public void whenMinElementIntegerTwo() {
        List<Integer> list = List.of(10, 11, 2, 3, 5, 8);
        MaxMin maxMin = new MaxMin();
        Integer min = maxMin.min(list, Integer::compare);
        assertThat(min, is(2));
    }
}