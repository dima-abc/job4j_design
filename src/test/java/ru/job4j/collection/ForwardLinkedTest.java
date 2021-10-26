package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 2.1.3. List
 * 3. Удалить head в односвязном списке.[#51424#127220]
 * 4. Используя контейнер на базе связанного списка
 * создать контейнер Stack[#71474#127214]
 * Test.
 *
 * @author Dima_Nout
 * @version 1
 * @since 25.10.2021
 */
public class ForwardLinkedTest {
    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        assertThat(linked.deleteFirst(), is(1));
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddFirstThen() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(3);
        linked.addFirst(2);
        linked.addFirst(5);
        linked.add(4);
        assertThat(linked.deleteFirst(), is(5));
        assertThat(linked.deleteFirst(), is(2));
        assertThat(linked.deleteFirst(), is(1));
        assertThat(linked.deleteFirst(), is(3));
        assertThat(linked.deleteFirst(), is(4));
    }

    @Test
    public void whenDeleteLastThen() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        assertThat(linked.deleteLast(), is(3));
        assertThat(linked.deleteLast(), is(2));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratotConcurrentModificationThenException() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        Iterator<Integer> iter = linked.iterator();
        iter.next();
        linked.add(4);
        iter.next();
    }

    @Test
    public void whenDeleteLestThenOneElement() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        assertThat(linked.deleteLast(), is(1));
    }

    @Test
    public void whenSizeGetThen3() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.addFirst(3);
        linked.addFirst(4);
        linked.add(5);
        linked.deleteLast();
        linked.deleteFirst();
        assertThat(linked.size(), is(3));
    }
}