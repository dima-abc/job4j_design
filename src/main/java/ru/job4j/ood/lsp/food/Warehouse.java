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
    public void add(Product type) {
        warehouseStore.add(type);
    }

    /**
     * Метод добавляет товар в хранилище с присвоением скидки.
     *
     * @param type Product
     * @param discount float
     */
    @Override
    public void add(Product type, float discount) {
        type.setDiscount(discount);
        add(type);
    }

    /**
     * Метод возвращает все содержимое хранилища.
     *
     * @return List
     */
    @Override
    public List<Product> findAll() {
        return this.warehouseStore;
    }
}
