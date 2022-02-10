package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 * Класс реализует хранилище Trash.
 *
 * @author Dmitry.
 * @since 09.02.2022.
 */
public class Trash implements Storage<Product> {
    private List<Product> trashStore = new ArrayList<>();

    /**
     * Метод добавляет type хранилище
     *
     * @param type Product
     */
    @Override
    public boolean add(Product type) {
        boolean result = false;
        if (accept(type)) {
            trashStore.add(type);
            result = true;
        }
        return result;
    }

    /**
     * Метод проверяет, может ли хранилище принять продукт.
     *
     * @param type Product
     * @return boolean
     */
    @Override
    public boolean accept(Product type) {
        return getValidity(type) >= 100;
    }

    /**
     * Метод возвращает все содержимое хранилища.
     *
     * @return List
     */
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(this.trashStore);
    }
}
