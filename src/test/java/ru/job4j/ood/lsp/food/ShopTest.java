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
        Product product = new Food("Bread", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(2), 30, 50);
        Storage<Product> shop = new Shop();
        shop.add(product);
        assertThat(shop.findAll(), is(List.of(product)));
    }

    @Test
    public void whenAddProductDiscount() {
        Product product = new Food("Bread", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(16), 30, 50);
        Storage<Product> shop = new Shop();
        shop.add(product);
        assertThat(product.getPrice(), is(15.0f));
    }

    @Test
    public void whenShopAcceptThenTrue() {
        Storage<Product> shop = new Shop();
        Product product = new Food("Bread", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(16), 30, 50);
        assertTrue(shop.accept(product));
    }

    @Test
    public void whenShopAcceptThenFalse() {
        Storage<Product> shop = new Shop();
        Product product = new Food("Bread", LocalDate.now().plusDays(5),
                LocalDate.now(), 30, 50);
        assertFalse(shop.accept(product));
    }

    @Test
    public void whenFindAllProduct() {
        Product bread = new Food("Bread", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(2), 30, 50);
        Product cheese = new Food("Cheese", LocalDate.now().plusDays(38),
                LocalDate.now().minusDays(42), 233.55f, 50);
        Product milk = new Food("Milk", LocalDate.now().plusDays(13),
                LocalDate.now().minusDays(5), 80, 50);
        Product sourCream = new Food("Sour Cream", LocalDate.now().plusDays(18),
                LocalDate.now().minusDays(9), 120, 50);
        Storage<Product> shop = new Shop();
        shop.add(bread);
        shop.add(cheese);
        shop.add(milk);
        shop.add(sourCream);
        assertThat(shop.findAll(), is(List.of(bread, cheese, milk, sourCream)));
    }
}