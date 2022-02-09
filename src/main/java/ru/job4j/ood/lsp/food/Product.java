package ru.job4j.ood.lsp.food;


import java.time.LocalDate;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 * Интерфейс реализует поведение модели данных Product.
 *
 * @author Dmitry.
 * @since 09.02.2022.
 */
public interface Product {
    String getName();

    LocalDate getExpiryDate();

    LocalDate getCreateDate();

    float getPrice();

    float getDiscount();

    void setDiscount(float discount);

    float getValidity();
}
