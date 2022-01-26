package ru.job4j.cache;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 * Пункт меню загрузка файла в КЭШ.
 *
 * @author Dima_Nout
 * @since 26.01.2022
 */
public class LoadDirDialog implements Dialog {
    @Override
    public String name() {
        return "Load file content into cache";
    }

    @Override
    public boolean execute(Input input, Emulator emulator) {
        System.out.println("=== Load file content into cache ===");
        String key = input.askStr("Enter load file: ");
        emulator.getAbstractCache().load(key);
        System.out.println("Load file: " + key);
        return true;
    }
}
