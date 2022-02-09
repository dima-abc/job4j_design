package ru.job4j.ood.lsp.food;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 * Sorter ControllQuality Test
 *
 * @author Dmitry.
 * @since 09.02.2022.
 */
public class ControllQualityTest {

    @Test
    public void whenSorterQualityThenAllToShoop() {
        Storage<Product> warehouse = new Warehouse();
        Storage<Product> shop = new Shop();
        Storage<Product> trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(warehouse, shop, trash, 50.00f);
        Product bread = new Food("Bread", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 1), 30);
        Product cheese = new Food("Cheese", LocalDate.of(2022, 3, 20),
                LocalDate.of(2021, 12, 1), 233.55f);
        Product milk = new Food("Milk", LocalDate.of(2022, 2, 23),
                LocalDate.of(2022, 2, 1), 80);
        Product sourCream = new Food("Sour Cream", LocalDate.of(2022, 2, 28),
                LocalDate.of(2022, 2, 1), 120);
        controllQuality.sorterQuality(bread);
        controllQuality.sorterQuality(cheese);
        controllQuality.sorterQuality(milk);
        controllQuality.sorterQuality(sourCream);
        assertThat(shop.findAll(), is(List.of(bread, cheese, milk, sourCream)));
    }

    @Test
    public void whenSorterQualityThenAllTrash() {
        Storage<Product> warehouse = new Warehouse();
        Storage<Product> shop = new Shop();
        Storage<Product> trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(warehouse, shop, trash, 50.00f);
        Product bread = new Food("Bread", LocalDate.of(2022, 2, 9),
                LocalDate.of(2022, 2, 1), 30);
        Product cheese = new Food("Cheese", LocalDate.of(2022, 2, 9),
                LocalDate.of(2021, 12, 1), 233.55f);
        Product milk = new Food("Milk", LocalDate.of(2022, 2, 9),
                LocalDate.of(2022, 2, 1), 80);
        Product sourCream = new Food("Sour Cream", LocalDate.of(2022, 2, 9),
                LocalDate.of(2022, 2, 1), 120);
        controllQuality.sorterQuality(bread);
        controllQuality.sorterQuality(cheese);
        controllQuality.sorterQuality(milk);
        controllQuality.sorterQuality(sourCream);
        assertThat(trash.findAll(), is(List.of(bread, cheese, milk, sourCream)));
    }

    @Test
    public void whenSorterQualityThenAllWarehouse() {
        Storage<Product> warehouse = new Warehouse();
        Storage<Product> shop = new Shop();
        Storage<Product> trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(warehouse, shop, trash, 50.00f);
        Product bread = new Food("Bread", LocalDate.of(2022, 3, 15),
                LocalDate.of(2022, 2, 8), 30);
        Product cheese = new Food("Cheese", LocalDate.of(2022, 6, 23),
                LocalDate.of(2022, 1, 8), 233.55f);
        Product milk = new Food("Milk", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 8), 80);
        Product sourCream = new Food("Sour Cream", LocalDate.of(2022, 3, 9),
                LocalDate.of(2022, 2, 8), 120);
        controllQuality.sorterQuality(bread);
        controllQuality.sorterQuality(cheese);
        controllQuality.sorterQuality(milk);
        controllQuality.sorterQuality(sourCream);
        assertThat(warehouse.findAll(), is(List.of(bread, cheese, milk, sourCream)));
    }

    @Test
    public void whenSorterQualityThenBreadWarehouseCheeseShopMilkShopDiscountSourCreamTrash() {
        Storage<Product> warehouse = new Warehouse();
        Storage<Product> shop = new Shop();
        Storage<Product> trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(warehouse, shop, trash, 50.00f);
        Product bread = new Food("Bread", LocalDate.of(2022, 3, 15),
                LocalDate.of(2022, 2, 8), 30);
        Product cheese = new Food("Cheese", LocalDate.of(2022, 4, 23),
                LocalDate.of(2022, 1, 8), 233.55f);
        Product milk = new Food("Milk", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 1, 1), 80);
        Product sourCream = new Food("Sour Cream", LocalDate.of(2022, 2, 9),
                LocalDate.of(2022, 1, 8), 120);
        controllQuality.sorterQuality(bread);
        controllQuality.sorterQuality(cheese);
        controllQuality.sorterQuality(milk);
        controllQuality.sorterQuality(sourCream);
        assertThat(warehouse.findAll(), is(List.of(bread)));
        assertThat(shop.findAll(), is(List.of(cheese, milk)));
        assertThat(milk.getPrice(), is(40.00f));
        assertThat(trash.findAll(), is(List.of(sourCream)));
    }
}