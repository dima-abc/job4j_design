package ru.job4j.cache;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 * Пункт меню получить файл из КЭШ.
 *
 * @author Dima_Nout
 * @since 26.01.2022
 */
public class GetDirDialog implements Dialog {
    @Override
    public String name() {
        return "Get file content from cache";
    }

    @Override
    public boolean execute(Input input, Emulator emulator) {
        System.out.println("=== Get file content from cache ===");
        String key = input.askStr("Enter get file: ");
        System.out.println(emulator.getAbstractCache().get(key));
        return true;
    }
}
