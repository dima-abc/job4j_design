package ru.job4j.collection.it;

import org.junit.Test;
import ru.job4j.collection.it.BackwardArrayIt;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 2.1.1 Iterator
 * 1. Что такое итератор.test.
 * Задание. Итератор должен отдавать элементы массива в обратном порядке.
 *
 * @author Dima_Nout
 * @version 1
 * @since 15.10.2021
 */
public class BackwardArrayItTest {
    @Test
    public void whenMultiCallHasNextThenTrue() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{}
        );
        it.next();
    }
}