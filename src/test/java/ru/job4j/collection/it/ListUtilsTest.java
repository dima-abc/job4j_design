package ru.job4j.collection.it;

import org.junit.Test;
import ru.job4j.collection.it.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * 2.1.3.List
 * 7.ListIterator[#350217]
 * Test.
 *
 * @author Dima_Nout
 * @version 1
 * @since 31.10.2021
 */
public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 3, 2);
    }

    @Test
    public void whenAddAfterLastThenIndexTwo() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 4));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3, 4)));
    }

    @Test
    public void whenRemoveIfPredicateAfterOneElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ListUtils.removeIf(input, f -> f > 2);
        assertThat(input, is(Arrays.asList(0, 1, 2)));
    }

    @Test
    public void whenRemoveIfPredicateBeforeTwoElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 0, 2, 3));
        ListUtils.removeIf(input, f -> f == 0);
        assertThat(input, is(Arrays.asList(2, 3)));
    }

    @Test
    public void whenRemoveIfPredicateMidstTwoElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ListUtils.removeIf(input, f -> f > 0 && f < 3);
        assertThat(input, is(Arrays.asList(0, 3)));
    }

    @Test
    public void whenRemoveIfPredicateNoElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ListUtils.removeIf(input, f -> f > 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenReplaceIfPredicateAfterOneElementThenTen() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ListUtils.replaceIf(input, f -> f > 2, 10);
        assertThat(input, is(Arrays.asList(0, 1, 2, 10)));
    }

    @Test
    public void whenReplaceIfPredicateBeforeOneElementThenTen() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ListUtils.replaceIf(input, f -> f < 1, 10);
        assertThat(input, is(Arrays.asList(10, 1, 2, 3)));
    }

    @Test
    public void whenReplaceIfPredicateMidstTwoElementThenTen() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ListUtils.replaceIf(input, f -> f > 0 && f < 3, 10);
        assertThat(input, is(Arrays.asList(0, 10, 10, 3)));
    }

    @Test
    public void whenReplaceIfPredicateNoElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ListUtils.replaceIf(input, f -> f > 3, 10);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveAllThenListTwoElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        List<Integer> remove = List.of(0, 1, 2);
        ListUtils.removeAll(input, remove);
        assertThat(input, is(Arrays.asList(3, 4, 5)));
    }

    @Test
    public void whenRemoveAllThenListAfterAndBeforeElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 1, 2, 3));
        List<Integer> remove = List.of(0, 1, 2);
        ListUtils.removeAll(input, remove);
        assertThat(input, is(Arrays.asList(3, 4, 5, 3)));
    }
}