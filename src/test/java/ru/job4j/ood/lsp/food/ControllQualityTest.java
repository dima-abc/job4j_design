package ru.job4j.ood.lsp.food;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
    public void whenResortedShopToTrashThenTrue() {
        Storage<Product> warehouse = new Warehouse();
        Storage<Product> shop = new Shop();
        Storage<Product> trash = new Trash();
        List<Storage<Product>> storages = Arrays.asList(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(storages);
        Product bread = new Food("Bread", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(9), 30, 50);
        Product cheese = new Food("Cheese", LocalDate.now().plusDays(38),
                LocalDate.now().minusDays(71), 233.55f, 50);
        Product milk = new Food("Milk", LocalDate.now().plusDays(13),
                LocalDate.now().minusDays(9), 80, 50);
        Product sourCream = new Food("Sour Cream", LocalDate.now().plusDays(18),
                LocalDate.now().minusDays(8), 120, 50);
        List<Product> products = Arrays.asList(bread, cheese, milk, sourCream);
        for (Product product : products) {
            controllQuality.sorterQuality(product);
        }
        assertThat(shop.findAll(), is(products));
        bread.setExpiryDate(LocalDate.now());
        cheese.setExpiryDate(LocalDate.now());
        milk.setExpiryDate(LocalDate.now());
        sourCream.setExpiryDate(LocalDate.now());
        controllQuality.resort();
        assertThat(trash.findAll(), is(products));
    }

    @Test
    public void whenResortShopToWarehouseThenTrue() {
        Storage<Product> warehouse = new Warehouse();
        Storage<Product> shop = new Shop();
        Storage<Product> trash = new Trash();
        List<Storage<Product>> storages = Arrays.asList(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(storages);
        Product bread = new Food("Bread", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(9), 30, 50);
        Product cheese = new Food("Cheese", LocalDate.now().plusDays(38),
                LocalDate.now().minusDays(71), 233.55f, 50);
        Product milk = new Food("Milk", LocalDate.now().plusDays(13),
                LocalDate.now().minusDays(9), 80, 50);
        Product sourCream = new Food("Sour Cream", LocalDate.now().plusDays(18),
                LocalDate.now().minusDays(8), 120, 50);
        List<Product> products = Arrays.asList(bread, cheese, milk, sourCream);
        for (Product product : products) {
            controllQuality.sorterQuality(product);
        }
        assertThat(shop.findAll(), is(products));
        bread.setExpiryDate(LocalDate.now().plusDays(33));
        cheese.setExpiryDate(LocalDate.now().plusDays(500));
        milk.setExpiryDate(LocalDate.now().plusDays(500));
        sourCream.setExpiryDate(LocalDate.now().plusDays(27));
        controllQuality.resort();
        assertThat(warehouse.findAll(), is(products));
    }

    @Test
    public void whenSorterQualityThenAllToShoop() {
        Storage<Product> warehouse = new Warehouse();
        Storage<Product> shop = new Shop();
        Storage<Product> trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(warehouse, shop, trash));
        Product bread = new Food("Bread", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(9), 30, 50);
        Product cheese = new Food("Cheese", LocalDate.now().plusDays(38),
                LocalDate.now().minusDays(71), 233.55f, 50);
        Product milk = new Food("Milk", LocalDate.now().plusDays(13),
                LocalDate.now().minusDays(9), 80, 50);
        Product sourCream = new Food("Sour Cream", LocalDate.now().plusDays(18),
                LocalDate.now().minusDays(8), 120, 50);
        List<Product> products = Arrays.asList(bread, cheese, milk, sourCream);
        for (Product product : products) {
            controllQuality.sorterQuality(product);
        }
        assertThat(shop.findAll(), is(products));
    }

    @Test
    public void whenSorterQualityThenAllTrash() {
        Storage<Product> warehouse = new Warehouse();
        Storage<Product> shop = new Shop();
        Storage<Product> trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(List.of(warehouse, shop, trash));
        Product bread = new Food("Bread", LocalDate.now(),
                LocalDate.now().minusDays(10), 30, 50);
        Product cheese = new Food("Cheese", LocalDate.now(),
                LocalDate.now().minusDays(120), 233.55f, 50);
        Product milk = new Food("Milk", LocalDate.now(),
                LocalDate.now().minusDays(55), 80, 50);
        Product sourCream = new Food("Sour Cream", LocalDate.now(),
                LocalDate.now().minusDays(99), 120, 50);
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
        ControllQuality controllQuality = new ControllQuality(List.of(warehouse, shop, trash));
        Product bread = new Food("Bread", LocalDate.now().plusDays(33),
                LocalDate.now().minusDays(2), 30, 50);
        Product cheese = new Food("Cheese", LocalDate.now().plusDays(139),
                LocalDate.now().minusDays(33), 233.55f, 50);
        Product milk = new Food("Milk", LocalDate.now().plusDays(5),
                LocalDate.now(), 80, 50);
        Product sourCream = new Food("Sour Cream", LocalDate.now().plusDays(27),
                LocalDate.now().minusDays(2), 120, 50);
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
        ControllQuality controllQuality = new ControllQuality(List.of(warehouse, shop, trash));
        Product bread = new Food("Bread", LocalDate.now().plusDays(33),
                LocalDate.now().minusDays(2), 30, 50);
        Product cheese = new Food("Cheese", LocalDate.now().plusDays(73),
                LocalDate.now().minusDays(33), 233.55f, 50);
        Product milk = new Food("Milk", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(40), 80, 50);
        Product sourCream = new Food("Sour Cream", LocalDate.now(),
                LocalDate.now().minusDays(33), 120, 50);
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