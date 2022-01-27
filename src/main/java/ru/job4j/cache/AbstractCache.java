package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 * Абстрактная структура данных Кэш.
 *
 * @param <K> Key
 * @param <V> Value
 * @author Dima_Nout
 * @since 24.01.2022
 */
public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.putIfAbsent(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V result = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (result == null) {
            result = load(key);
            put(key, result);
        }
        return result;
    }

    /**
     * Фабричный метод для загрузки данных в КЭШ.
     *
     * @param key K
     * @return V
     */
    protected abstract V load(K key);
}
