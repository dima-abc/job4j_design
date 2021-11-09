package ru.job4j.map;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {
    private SimpleMap<String, Integer> simpleMap;

    @Before
    public void setUp() {
        simpleMap = new SimpleMap<>();
    }

    @Test
    public void whenPutKeyThenTrue() {
        assertTrue(simpleMap.put("One", 1));
    }

    @Test
    public void whenPutEqualsKeyThenTrueAndFalse() {
        assertTrue(simpleMap.put("One", 1));
        assertFalse(simpleMap.put("One", 1));
    }

    @Test
    public void whenGetSizeMapThenSizeFive() {
        simpleMap.put("1", 1);
        simpleMap.put("2", 2);
        simpleMap.put("3", 3);
        simpleMap.put("4", 4);
        simpleMap.put("5", 5);
        assertFalse(simpleMap.put("1", 1));
        assertTrue(simpleMap.put("1", 2));
        assertThat(simpleMap.getSize(), is(5));
    }

    @Test
    public void whenGetSizeMapAddTwoEqualsElementThenSizeOne() {
        simpleMap.put("One", 1);
        simpleMap.put("One", 2);
        assertThat(simpleMap.getSize(), is(1));
    }

    @Test
    public void whenGetThenNull() {
        simpleMap.put("One", 1);
        assertNull(simpleMap.get("Two"));
    }

    @Test
    public void whenGetKeyOneThenValue1() {
        simpleMap.put("One", 2);
        simpleMap.put("One", 1);
        assertThat(simpleMap.get("One"), is(1));
    }

    @Test
    public void whenExpendMapByPutSixElementThenNewCapacityAndSizeSix() {
        simpleMap.put("1", 1);
        simpleMap.put("2", 2);
        simpleMap.put("3", 3);
        simpleMap.put("4", 4);
        simpleMap.put("5", 5);
        simpleMap.put("6", 6);
        simpleMap.put("7", 7);
        assertThat(simpleMap.getSize(), is(7));
        assertThat(simpleMap.get("6"), is(6));
    }

    @Test
    public void whenRemoveThenFalse() {
        simpleMap.put("First", 11);
        assertFalse(simpleMap.remove("11"));
    }

    @Test
    public void whenremoveThenTrue() {
        simpleMap.put("First", 11);
        simpleMap.put("Second", 222);
        assertTrue(simpleMap.remove("First"));
        assertFalse(simpleMap.remove("First"));
        assertTrue(simpleMap.remove("Second"));
        assertFalse(simpleMap.remove("Second"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorConcurrentModificationThenExeption() {
        simpleMap.put("one", 11);
        Iterator<String> iterator = simpleMap.iterator();
        simpleMap.put("Two", 22);
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorNoSuchElementThenException() {
        Iterator<String> iterator = simpleMap.iterator();
        iterator.next();
    }

    @Test
    public void whenIteratorHasNextThenTrue() {
        simpleMap.put("one", 1);
        Iterator<String> iterator = simpleMap.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
    }

    @Test
    public void whenIteratorHasNextThenTrueAndFalse() {
        simpleMap.put("One", 1);
        simpleMap.put("Two", 2);
        Iterator<String> iterator = simpleMap.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }
}