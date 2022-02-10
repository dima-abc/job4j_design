package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 * Класс реализует хранилище Shop.
 *
 * @author Dmitry
 * @since 09.02.2022
 */
public class Shop implements Storage<Product> {
    private List<Product> shopStore = new ArrayList<>();

    /**
     * Метод добавляет type хранилище
     *
     * @param type Product
     */
    @Override
    public boolean add(Product type) {
        boolean result = false;
        if (accept(type)) {
            shopStore.add(type);
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
        boolean result = false;
        if (getValidity(type) > 25 && getValidity(type) <= 75) {
            result = true;
        } else if (getValidity(type) > 75 && this.getValidity(type) < 100) {
            setDiscount(type);
            result = true;
        }
        return result;
    }

    /**
     * Метод применяет скидку к товару.
     *
     * @param product Product
     */
    private void setDiscount(Product product) {
        if (product.getDiscount() != 0) {
            float price = product.getPrice();
            float discount = product.getDiscount();
            price -= price * discount / 100;
            product.setPrice(price);
        }
    }

    /**
     * Метод возвращает все содержимое хранилища.
     *
     * @return List
     */
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(this.shopStore);
    }
}
