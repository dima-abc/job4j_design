package ru.job4j.ood.lsp;

import org.junit.Test;
import ru.job4j.ood.lsp.food.Food;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FoodTest {
    @Test
    public void whenDateTest() {
        Food food = new Food("Сыр", LocalDateTime.of(2022, 3, 1, 0, 0),
                LocalDateTime.of(2021, 12, 1, 0, 0), 200.00f);
        LocalDateTime dateTime = LocalDateTime.of(2021, 3, 1, 0, 0);
        long dateCreate = food.getCreateDate().getLong(ChronoField.EPOCH_DAY);
        long dateExpiry = food.getExpiryDate().getLong(ChronoField.EPOCH_DAY);
        long now = LocalDateTime.now().withNano(0).getLong(ChronoField.EPOCH_DAY);
        float percent = (float) (dateExpiry - now) / (dateExpiry - dateCreate) * 100;
        System.out.printf("%.2f", percent);
    }

    @Test
    public void whenSetDiscount() {
        Food food = new Food("Сыр", LocalDateTime.of(2022, 3, 1, 0, 0),
                LocalDateTime.of(2021, 12, 1, 0, 0), 200.00F);
        food.setDiscount(50.00f);
        assertThat(food.getPrice(), is(100.00f));
    }

}