package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;

public interface Storage<T> {
    T add(T type, Predicate<T> predicate);

    List<T> findAll();

    List<T> findBy(Predicate<T> predicate);
}
