package ru.job4j.ood.isp.menu;

/**
 * 2.5.4. ISP
 * 1. Создать меню.
 * TODOApp. Служит для построения и вывода списка задач пользователя.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.02.2022
 */
public class TODOApp {
    private Menu menu;
    private ActionDelegate actionDelegate;
    private MenuPrinter menuPrinter;

    public TODOApp(Menu menu, ActionDelegate actionDelegate, MenuPrinter menuPrinter) {
        this.menu = menu;
        this.actionDelegate = actionDelegate;
        this.menuPrinter = menuPrinter;
    }

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        ActionDelegate actionDelegate = System.out::println;
        MenuPrinter menuPrinter = new SimpleMenuPrint("-");
        menu.add(Menu.ROOT, "Джуниор", actionDelegate);
        menu.add("Джуниор", "ООД", actionDelegate);
        menu.add("OOД", "TDD", actionDelegate);
        menu.add("TDD", "Принципы Kiss, Dry и Yagni", actionDelegate);
        menu.add("TDD", "Что такое TDD?", actionDelegate);
        menu.add("ООД", "SRP", actionDelegate);
        menu.add("SRP", "Принцип единственной ответственности", actionDelegate);
        menu.add("SRP", "Отчеты", actionDelegate);
        menu.add("Джуниор", "Контрольные вопросы", actionDelegate);
        menuPrinter.print(menu);
    }
}
