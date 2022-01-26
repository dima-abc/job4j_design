package ru.job4j.cache;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);
}
