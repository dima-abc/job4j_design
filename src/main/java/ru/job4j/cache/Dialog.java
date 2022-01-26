package ru.job4j.cache;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 * Базовый диалог для создания фабрики.
 *
 * @author Dima_Nout
 * @since 26.01.2022.
 */
public interface Dialog {
    String name();

    boolean execute(Input input, Emulator emulator);
}
