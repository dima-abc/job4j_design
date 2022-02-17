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
            setDiscount(type, p -> getValidity(p) > 75 && getValidity(p) < 100);
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
        return getValidity(type) > 25 && getValidity(type) < 100;
    }

    /**
     * Метод применяет скидку к товару.
     *
     * @param product Product
     */
    private void setDiscount(Product product, Predicate<Product> predicate) {
        if (product.getDiscount() != 0 && predicate.test(product)) {
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

    /**
     * Метод очищает хранилище.
     * В данном методе дополнительно отменяется скидка.
     */
    @Override
    public void clear() {
        shopStore.clear();
    }
}
