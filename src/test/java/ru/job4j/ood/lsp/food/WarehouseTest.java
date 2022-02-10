package ru.job4j.ood.lsp.food;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852].
 * Storage Warehouse test.
 *
 * @author Dmitry.
 * @since 09.02.2022.
 */
public class WarehouseTest {

    @Test
    public void whenAddProduct() {
        Product product = new Food("Bread", LocalDate.of(2022, 2, 28),
                LocalDate.of(2022, 2, 8), 30, 50);
        Storage<Product> warehouse = new Warehouse();
        warehouse.add(product);
        assertThat(warehouse.findAll(), is(List.of(product)));
    }

    @Test
    public void whenAddProductDiscount() {
        Product product = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 8), 30, 50);
        Storage<Product> warehouse = new Warehouse();
        warehouse.add(product);
        assertThat(product.getPrice(), is(30.0f));
    }

    @Test
    public void whenFindAllProduct() {
        Product bread = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 10), 30, 50);
        Product cheese = new Food("Cheese", LocalDate.of(2022, 3, 20),
                LocalDate.of(2022, 2, 5), 233.55f, 50);
        Product milk = new Food("Milk", LocalDate.of(2022, 2, 23),
                LocalDate.of(2022, 2, 9), 80, 50);
        Product sourCream = new Food("Sour Cream", LocalDate.of(2022, 2, 28),
                LocalDate.of(2022, 2, 5), 120, 50);
        Storage<Product> warehouse = new Warehouse();
        warehouse.add(bread);
        warehouse.add(cheese);
        warehouse.add(milk);
        warehouse.add(sourCream);
        System.out.println(warehouse.getValidity(bread)
                + "\n" + warehouse.getValidity(cheese)
                + "\n" + warehouse.getValidity(milk)
                + "\n" + warehouse.getValidity(sourCream));
        assertThat(warehouse.findAll(), is(List.of(bread, cheese, milk, sourCream)));
    }

    @Test
    public void whenWarehouseAcceptThenTrue() {
        Storage<Product> warehouse = new Warehouse();
        Product product = new Food("Bread", LocalDate.of(2022, 3, 15),
                LocalDate.of(2022, 2, 10), 30, 50);
        assertTrue(warehouse.accept(product));
    }

    @Test
    public void whenWarehouseAcceptThenFalse() {
        Storage<Product> warehouse = new Warehouse();
        Product product = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 1, 10), 30, 50);
        assertFalse(warehouse.accept(product));
    }
}