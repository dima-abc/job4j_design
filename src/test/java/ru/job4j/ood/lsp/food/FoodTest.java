package ru.job4j.ood.lsp.food;

import org.junit.Test;
import ru.job4j.ood.lsp.food.Food;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FoodTest {
    @Test
    public void whenValidityThen100Percent() {
        Food food = new Food("Cheese", LocalDate.of(2022, 2, 9),
                LocalDate.of(2022, 2, 1), 250.00f);
        assertThat(food.getValidity(), is(100.00f));
    }

    @Test
    public void whenValidityThen50Percent() {
        Food food = new Food("Cheese", LocalDate.of(2022, 2, 18),
                LocalDate.of(2022, 1, 31), 250.00f);
        assertThat(food.getValidity(), is(50.00f));
    }

    @Test
    public void whenSetDiscount50Price200Then100() {
        Food food = new Food("Сыр", LocalDate.of(2022, 3, 1),
                LocalDate.of(2021, 12, 1), 200.00F);
        food.setDiscount(50.00f);
        assertThat(food.getPrice(), is(100.00f));
    }

    @Test
    public void whenSetDiscount30Price200Then140() {
        Food food = new Food("Cheese", LocalDate.of(2022, 2, 18),
                LocalDate.of(2022, 1, 31), 200.00f);
        food.setDiscount(30.00f);
        assertThat(food.getPrice(), is(140.00f));
    }

}