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
                LocalDate.of(2022, 2, 8), 30);
        Storage<Product> shop = new Shop();
        shop.add(product);
        assertThat(shop.findAll(), is(List.of(product)));
    }

    @Test
    public void whenAddProductDiscount() {
        Product product = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 8), 30);
        Storage<Product> shop = new Shop();
        shop.add(product, 50);
        assertThat(product.getPrice(), is(15.0f));
    }

    @Test
    public void whenFindAllProduct() {
        Product bread = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 8), 30);
        Product cheese = new Food("Cheese", LocalDate.of(2022, 3, 20),
                LocalDate.of(2021, 12, 5), 233.55f);
        Product milk = new Food("Milk", LocalDate.of(2022, 2, 23),
                LocalDate.of(2022, 2, 9), 80);
        Product sourCream = new Food("Sour Cream", LocalDate.of(2022, 2, 28),
                LocalDate.of(2022, 2, 1), 120);
        Storage<Product> shop = new Shop();
        shop.add(bread);
        shop.add(cheese);
        shop.add(milk);
        shop.add(sourCream);
        assertThat(shop.findAll(), is(List.of(bread, cheese, milk, sourCream)));
    }
}