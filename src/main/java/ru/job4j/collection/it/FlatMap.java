package ru.job4j.collection.it;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2.1.1.Iterator
 * 5.1.4. FlatMap для Iterator<Iterator>
 *
 * @param <T> Object
 * @author Dmitry
 * @version 1
 * @since 18.10.2021
 */
public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (data.hasNext() && !cursor.hasNext()) {
            cursor = data.next();
        }
        return cursor.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }
}
