package ru.job4j.ood.lsp.food;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
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
    boolean add(T type);

    List<T> findAll();

    boolean accept(T type);

    void clear();

    /**
     * Метод возвращает процент окончания срока годности.
     *
     * @return Validity percent.
     */
    default float getValidity(Product product) {
        float now = LocalDate.now().getLong(ChronoField.EPOCH_DAY);
        float expiryDate = product.getExpiryDate().getLong(ChronoField.EPOCH_DAY);
        float createDate = product.getCreateDate().getLong(ChronoField.EPOCH_DAY);
        float result = 100 - (expiryDate - now) / (expiryDate - createDate) * 100;
        return result < 100 ? result : 100;
    }
}
