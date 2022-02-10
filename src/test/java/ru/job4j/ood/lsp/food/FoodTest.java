package ru.job4j.ood.lsp.food;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FoodTest {
    @Test
    public void whenValidityThen100Percent() {
        Food food = new Food("Cheese", LocalDate.of(2022, 2, 10),
                LocalDate.of(2022, 2, 1), 250.00f, 0);
        Storage<Product> storage = new Shop();
        assertThat(storage.getValidity(food), is(100.00f));
    }

    @Test
    public void whenValidityThen50Percent() {
        Food food = new Food("Cheese", LocalDate.of(2022, 2, 18),
                LocalDate.of(2022, 2, 2), 250.00f, 0);
        Storage<Product> storage = new Shop();
        assertThat(storage.getValidity(food), is(50.00f));
    }

    @Test
    public void whenSetDiscount50Price200Then100() {
        Food food = new Food("Сыр", LocalDate.of(2022, 3, 1),
                LocalDate.of(2021, 12, 1), 200.00F, 50.00f);
        Storage<Product> storage = new Shop();
        storage.add(food);
        assertThat(food.getPrice(), is(100.00f));
    }

    @Test
    public void whenSetDiscount30Price200Then140() {
        Food food = new Food("Cheese", LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 1, 25), 200.00f, 30.00f);
        Storage<Product> storage = new Shop();
        storage.add(food);
        assertThat(food.getPrice(), is(140.00f));
    }

}