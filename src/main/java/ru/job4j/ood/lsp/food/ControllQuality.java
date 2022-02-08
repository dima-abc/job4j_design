package ru.job4j.ood.lsp.food;


import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class ControllQuality {
    private Storage<Food> warehouse;
    private Storage<Food> shop;
    private Storage<Food> trash;

    public ControllQuality(Storage<Food> warehouse, Storage<Food> shop, Storage<Food> trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void sorter(Food food) {
        float validity = validityTerm(food);
        trash.add(food, f -> validity >= 100);
        warehouse.add(food, f -> validity < 25);
        shop.add(food, f -> validity >= 25 && validity <= 75);
        if (validity > 75 && validity < 100) {
            food.setDiscount(50.00f);
            shop.add(food, f -> true);
        }
    }

    private float validityTerm(Food food) {
        long now = LocalDate.now().getLong(ChronoField.EPOCH_DAY);
        long expiryDate = food.getExpiryDate().getLong(ChronoField.EPOCH_DAY);
        long createDate = food.getCreateDate().getLong(ChronoField.EPOCH_DAY);
        return 100.00f - (float) ((expiryDate - now) / (expiryDate - createDate) * 100);
    }
}
