package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Warehouse implements Storage<Food> {
    private List<Food> warehouseStore = new ArrayList<>();

    @Override
    public Food add(Food type, Predicate<Food> predicate) {
        Food result = null;
        if (predicate.test(type)) {
            warehouseStore.add(type);
            result = type;
        }
        return result;
    }

    @Override
    public List<Food> findAll() {
        return this.warehouseStore;
    }

    @Override
    public List<Food> findBy(Predicate<Food> predicate) {
        List<Food> result = new ArrayList<>();
        for (Food food : this.warehouseStore) {
            if (predicate.test(food)) {
                result.add(food);
            }
        }
        return result;
    }
}
