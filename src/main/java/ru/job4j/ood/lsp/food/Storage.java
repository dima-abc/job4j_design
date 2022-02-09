package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 * Интерфейс описывает поведение хранилища.
 *
 * @param <T> Type.
 */
public interface Storage<T> {
    void add(T type);

    void add(T type, float discount);

    List<T> findAll();
}
