package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 * Класс реализует хранилище Warehouse.
 *
 * @author Dmitry
 * @since 09.02.2022.
 */
public class Warehouse implements Storage<Product> {
    private List<Product> warehouseStore = new ArrayList<>();

    /**
     * Метод добавляет товар в хранилище.
     *
     * @param type Type.
     */
    @Override
    public boolean add(Product type) {
        boolean result = false;
        if (accept(type)) {
            warehouseStore.add(type);
            result = true;
        }
        return result;
    }

    /**
     * Метод проверяет, может ли хранилище принять продукт.
     *
     * @param type Product.
     * @return boolean.
     */
    @Override
    public boolean accept(Product type) {
        return getValidity(type) <= 25;
    }

    /**
     * Метод возвращает все содержимое хранилища.
     *
     * @return List
     */
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(this.warehouseStore);
    }
}
