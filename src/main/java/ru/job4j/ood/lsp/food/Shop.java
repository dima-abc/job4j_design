package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Storage<Food> {
    private List<Food> shopStore = new ArrayList<>();

    @Override
    public Food add(Food type, Predicate<Food> predicate) {
        return null;
    }

    @Override
    public List<Food> findAll() {
        return this.shopStore;
    }

    @Override
    public List<Food> findBy(Predicate<Food> predicate) {
        List<Food> result = new ArrayList<>();
        for (Food food : this.shopStore) {
            if (predicate.test(food)) {
                result.add(food);
            }
        }
        return result;
    }
}
