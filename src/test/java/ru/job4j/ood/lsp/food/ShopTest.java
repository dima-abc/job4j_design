package ru.job4j.ood.lsp.food;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 * Storage Shop test.
 *
 * @author Dmitry.
 * @since 09.02.2022.
 */
public class ShopTest {

    @Test
    public void whenAddProduct() {
        Product product = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 8), 30, 50);
        Storage<Product> shop = new Shop();
        shop.add(product);
        assertThat(shop.findAll(), is(List.of(product)));
    }

    @Test
    public void whenAddProductDiscount() {
        Product product = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 1, 25), 30, 50);
        Storage<Product> shop = new Shop();
        shop.add(product);
        assertThat(product.getPrice(), is(15.0f));
    }

    @Test
    public void whenShopAcceptThenTrue() {
        Storage<Product> shop = new Shop();
        Product product = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 1, 25), 30, 50);
        assertTrue(shop.accept(product));
    }

    @Test
    public void whenShopAcceptThenFalse() {
        Storage<Product> shop = new Shop();
        Product product = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 10), 30, 50);
        assertFalse(shop.accept(product));
    }

    @Test
    public void whenFindAllProduct() {
        Product bread = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 8), 30, 50);
        Product cheese = new Food("Cheese", LocalDate.of(2022, 3, 20),
                LocalDate.of(2021, 12, 30), 233.55f, 50);
        Product milk = new Food("Milk", LocalDate.of(2022, 2, 23),
                LocalDate.of(2022, 2, 5), 80, 50);
        Product sourCream = new Food("Sour Cream", LocalDate.of(2022, 2, 28),
                LocalDate.of(2022, 2, 1), 120, 50);
        Storage<Product> shop = new Shop();
        shop.add(bread);
        shop.add(cheese);
        shop.add(milk);
        shop.add(sourCream);
        assertThat(shop.findAll(), is(List.of(bread, cheese, milk, sourCream)));
    }
}