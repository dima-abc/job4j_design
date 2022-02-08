package ru.job4j.ood.lsp.food;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Food {
    private String name;
    private LocalDateTime expiryDate;
    private LocalDateTime createDate;
    private float price;
    private float discount = 0;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Food(String name, LocalDateTime expiryDate, LocalDateTime createDate, float price) {
        this.name = name;
        this.expiryDate = expiryDate.withNano(0);
        this.createDate = createDate.withNano(0);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        if (discount != 0) {
            this.discount = discount;
            this.price -= this.price * discount / 100;
        }
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
                && discount == food.discount
                && Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, discount);
    }

    @Override
    public String toString() {
        return String.format("name: %s, expiryDate: %s, createDate: %s, price: %.2f, discount: %.2f",
                name, expiryDate.format(dateFormatter), createDate.format(dateFormatter), price, discount);
    }
}
