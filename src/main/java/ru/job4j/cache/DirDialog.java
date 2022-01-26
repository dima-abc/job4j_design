package ru.job4j.cache;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 * Пункт меню задает каталог для кэширования.
 *
 * @author Dima_Nout
 * @since 26.01.2022
 */
public class DirDialog implements Dialog {
    @Override
    public String name() {
        return "Specify cached directory";
    }

    @Override
    public boolean execute(Input input, Emulator emulator) {
        System.out.println("=== Specify cache directory");
        String dir = input.askStr("Enter directory: ");
        emulator.setAbstractCache(new DirFileCache(dir));
        System.out.println("Specify by directory: " + dir);
        return true;
    }
}
