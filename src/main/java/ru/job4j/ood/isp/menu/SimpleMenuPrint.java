package ru.job4j.ood.isp.menu;

/**
 * 2.5.4. ISP
 * 1. Создать меню.
 * SimpleMenuPrint класс реализует вывод меню на консоль.
 *
 * @author Dmitry Stepanov, user Dima
 * @since 13.02.2022.
 */
public class SimpleMenuPrint implements MenuPrinter {
    private static final int TAB_LIMIT = 2;
    private final String tab;

    public SimpleMenuPrint(String tab) {
        this.tab = tab;
    }

    @Override
    public void print(Menu menu) {
        menu.forEach(i -> System.out.println(tabGenerate(i.getNumber()) + i.getNumber() + i.getName()));
    }

    private String tabGenerate(String number) {
        String result = "";
        if (number.length() > TAB_LIMIT) {
            result = tab.repeat(number.length()).concat(" ");
        }
        return result;
    }
}
