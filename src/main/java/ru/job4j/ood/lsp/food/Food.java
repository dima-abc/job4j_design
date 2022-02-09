package ru.job4j.ood.lsp.food;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Objects;

/**
 * 2.5.3. LSP
 * 1. Хранилище продуктов [#852]
 * Модель данных Food.
 *
 * @author Dmitry
 * @since 09.02.2022
 */
public class Food implements Product {
    private String name;
    private LocalDate expiryDate;
    private LocalDate createDate;
    private float price;
    private float discount = 0;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, float price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public float getDiscount() {
        return discount;
    }

    /**
     * Метод применяет скидку к товару.
     *
     * @param discount Discount percent.
     */
    @Override
    public void setDiscount(float discount) {
        if (discount != 0) {
            this.discount = discount;
            this.price -= this.price * discount / 100;
        }
    }

    /**
     * Метод возвращает процент окончания срока годности.
     *
     * @return Validity percent.
     */
    @Override
    public float getValidity() {
        float now = LocalDate.now().getLong(ChronoField.EPOCH_DAY);
        float expiryDate = this.getExpiryDate().getLong(ChronoField.EPOCH_DAY);
        float createDate = this.getCreateDate().getLong(ChronoField.EPOCH_DAY);
        return 100 - (expiryDate - now) / (expiryDate - createDate) * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Float.compare(food.price, price) == 0
                && Float.compare(food.discount, discount) == 0
                && Objects.equals(name, food.name)
                && Objects.equals(expiryDate, food.expiryDate)
                && Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expiryDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return String.format("name: %s, expiryDate: %s, createDate: %s, price: %.2f, discount: %.2f",
                name, expiryDate, createDate, price, discount);
    }
}
