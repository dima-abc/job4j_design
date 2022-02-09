package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.function.Predicate;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 * Класс реализует сортировку продуктов в хранилище.
 *
 * @author Dmitry.
 * @since 09.02.2022.
 */
public class ControllQuality implements Sorter<Product> {
    private Storage<Product> warehouse;
    private Storage<Product> shop;
    private Storage<Product> trash;
    private float discount;

    public ControllQuality(Storage<Product> warehouse, Storage<Product> shop, Storage<Product> trash, float discount) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
        this.discount = discount;
    }

    /**
     * Метод распределяет продукты по условию в разные хранилища.
     *
     * @param product Product.
     */
    public void sorterQuality(Product product) {
        sorter(product, warehouse, p -> p.getValidity() <= 25, 0);
        sorter(product, shop, p -> p.getValidity() > 25 && p.getValidity() <= 75, 0);
        sorter(product, shop, p -> p.getValidity() > 75 && p.getValidity() < 100, discount);
        sorter(product, trash, p -> p.getValidity() >= 100, 0);
    }

    /**
     * Метод добавляет в хранилище на основании условия.
     *
     * @param product   Product.
     * @param storage   Storage.
     * @param predicate Predicate.
     * @param discount  float.
     */
    @Override
    public void sorter(Product product, Storage<Product> storage, Predicate<Product> predicate, float discount) {
        if (predicate.test(product)) {
            storage.add(product, discount);
        }
    }
}
