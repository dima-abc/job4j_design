package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 *
 * @param <T> Type.
 */
public interface Sorter<T> {
    void sorter(T type, Storage<T> storage, Predicate<T> predicate, float discount);
}
