package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base> [#157 #127243]
 * Каркас универсального хранилища.
 *
 * @author Dmitry
 * @version 1
 * @since 19.10.2021
 */
public class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        Optional<T> result = Optional.ofNullable(mem.replace(id, model));
        return result.isPresent();
    }

    @Override
    public boolean delete(String id) {
        Optional<T> result = Optional.ofNullable(mem.remove(id));
        return result.isPresent();
    }

    @Override
    public T findById(String id) {
        return mem.get(id);
    }
}
