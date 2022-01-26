package ru.job4j.cache;

import java.util.List;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 * Клас Emulator для работы с пользователем.
 *
 * @author Dima_Nout
 * @since 26.01.2022
 */
public class Emulator {
    private AbstractCache abstractCache = null;

    public void setAbstractCache(AbstractCache cache) {
        this.abstractCache = cache;
    }

    public AbstractCache getAbstractCache() {
        return this.abstractCache;
    }

    /**
     * Инициализация приложение и выполнение пользовательских действий.
     *
     * @param input    Input.
     * @param emulator Emulator.
     * @param dialogs  List.
     */
    public void init(Input input, Emulator emulator, List<Dialog> dialogs) {
        boolean run = true;
        while (run) {
            this.showMenu(dialogs);
            int select = input.askInt("Select-> ");
            if (select < 0 || select >= dialogs.size()) {
                System.out.println("Wrong input, you can select: 0.." + (dialogs.size() - 1));
                continue;
            }
            Dialog dialog = dialogs.get(select);
            run = dialog.execute(input, emulator);
        }
    }

    /**
     * Отображение меню пользователя
     *
     * @param dialog List.
     */
    private void showMenu(List<Dialog> dialog) {
        System.out.println("Menu:");
        for (int i = 0; i < dialog.size(); i++) {
            System.out.println(i + ". " + dialog.get(i).name());
        }
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        Input input = new ConsoleInput();
        List<Dialog> dialogs = List.of(
                new DirDialog(),
                new LoadDirDialog(),
                new GetDirDialog(),
                new ExitDialog()
        );
        emulator.init(input, emulator, dialogs);
    }
}
