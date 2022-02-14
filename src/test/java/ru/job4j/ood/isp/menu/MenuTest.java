package ru.job4j.ood.isp.menu;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * 2.5.4. ISP
 * 1. Создать меню.
 * Test. Menu.
 *
 * @author Dmitry Stepanov, user Dima_Nout
 * @since 13.02.2022
 */
public class MenuTest {
    private static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertEquals(new Menu.MenuItemInfo(
                "Сходить в магазин", List.of("Купить продукты"), STUB_ACTION, "1."
        ), menu.select("Сходить в магазин").get());
        assertEquals(
                new Menu.MenuItemInfo(
                        "Купить продукты", List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."
                ), menu.select("Купить продукты").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "Покормить собаку", List.of(), STUB_ACTION, "2."
                ), menu.select("Покормить собаку").get()
        );
        new SimpleMenuPrint("-").print(menu);
    }

    @Test
    public void whenSelectReturnEmptyThenEmpty() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Start menu", STUB_ACTION);
        assertEquals(menu.select("End menu"), Optional.empty());
    }

    @Test
    public void whenSelectFirstMenuThenFirstMenu() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "First menu", STUB_ACTION);
        assertEquals(new Menu.MenuItemInfo("First menu", List.of(), STUB_ACTION, "1."),
                menu.select("First menu").get());
    }

    @Test
    public void whenSelectThreeChildMenuThenThreeChildMenu() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "First menu", STUB_ACTION);
        menu.add("First menu", "Two menu", STUB_ACTION);
        menu.add("Two menu", "Three menu", STUB_ACTION);
        assertEquals(new Menu.MenuItemInfo("Three menu", List.of(), STUB_ACTION, "1.1.1."),
                menu.select("Three menu").get());
    }
}