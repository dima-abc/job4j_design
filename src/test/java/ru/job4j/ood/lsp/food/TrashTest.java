package ru.job4j.ood.lsp.food;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 * Storage Trash test.
 *
 * @author Dmitry.
 * @since 09.02.2022.
 */
public class TrashTest {
    @Test
    public void whenAddProduct() {
        Product product = new Food("Bread", LocalDate.of(2022, 2, 10),
                LocalDate.of(2022, 2, 1), 30, 50);
        Storage<Product> shop = new Trash();
        shop.add(product);
        assertThat(shop.findAll(), is(List.of(product)));
    }

    @Test
    public void whenFindAllProduct() {
        Product bread = new Food("Bread", LocalDate.of(2022, 2, 10),
                LocalDate.of(2022, 2, 1), 30, 50);
        Product cheese = new Food("Cheese", LocalDate.of(2022, 2, 10),
                LocalDate.of(2021, 12, 1), 233.55f, 50);
        Product milk = new Food("Milk", LocalDate.of(2022, 2, 10),
                LocalDate.of(2022, 2, 1), 80, 50);
        Product sourCream = new Food("Sour Cream", LocalDate.of(2022, 2, 10),
                LocalDate.of(2022, 2, 1), 120, 50);
        Storage<Product> shop = new Trash();
        shop.add(bread);
        shop.add(cheese);
        shop.add(milk);
        shop.add(sourCream);
        System.out.println(shop.getValidity(bread)
                + "\n" + shop.getValidity(cheese)
                + "\n" + shop.getValidity(milk)
                + "\n" + shop.getValidity(sourCream));
        assertThat(shop.findAll(), is(List.of(bread, cheese, milk, sourCream)));
    }

    @Test
    public void whenTrashAcceptThenTrue() {
        Storage<Product> trash = new Trash();
        Product product = new Food("Bread", LocalDate.of(2022, 2, 10),
                LocalDate.of(2022, 2, 1), 30, 50);
        assertTrue(trash.accept(product));
    }

    @Test
    public void whenTrashAcceptThenFalse() {
        Storage<Product> trash = new Trash();
        Product product = new Food("Bread", LocalDate.of(2022, 12, 15),
                LocalDate.of(2022, 1, 10), 30, 50);
        assertFalse(trash.accept(product));
    }
}