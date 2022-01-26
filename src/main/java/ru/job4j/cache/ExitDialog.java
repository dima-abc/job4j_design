package ru.job4j.cache;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 * Пункт меню EXIT.
 *
 * @author Dima_Nout
 * @since 26.01.2022.
 */
public class ExitDialog implements Dialog {
    @Override
    public String name() {
        return "Exit program";
    }

    @Override
    public boolean execute(Input input, Emulator emulator) {
        System.out.println("=== By by ===");
        return false;
    }
}
