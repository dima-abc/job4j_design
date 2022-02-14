package ru.job4j.ood.isp.menu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.4. ISP
 * 1. Создать меню.
 * Test. MenuPrint.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.02.2022
 */
public class MenuPrinterTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static final ActionDelegate STUB_ACTION = System.out::println;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void whenSimpleMenuPrintThenOutOneMenu() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Start menu", STUB_ACTION);
        new SimpleMenuPrint("-").print(menu);
        String expected = String.join(System.lineSeparator(),
                "1.Start menu", "");
        assertThat(expected, is(outputStreamCaptor.toString()));
    }

    @Test
    public void whenSimpleMenuPrintThenOutTwoMenuAndChildrenMenu() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Open book", STUB_ACTION);
        menu.add(Menu.ROOT, "Close book", STUB_ACTION);
        menu.add("Open book", "Turn the page", STUB_ACTION);
        menu.add("Turn the page", "Tear out the page", STUB_ACTION);
        new SimpleMenuPrint("-").print(menu);
        String expected = String.join(System.lineSeparator(),
                "1.Open book",
                "---- 1.1.Turn the page",
                "------ 1.1.1.Tear out the page",
                "2.Close book", "");
        assertThat(expected, is(outputStreamCaptor.toString()));
    }

    @Test
    public void whenSimpleMenuPrint() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        new SimpleMenuPrint("*").print(menu);
        String expected = String.join(System.lineSeparator(),
                "1.Сходить в магазин",
                "**** 1.1.Купить продукты",
                "****** 1.1.1.Купить хлеб",
                "****** 1.1.2.Купить молоко",
                "2.Покормить собаку", "");
        assertThat(expected, is(outputStreamCaptor.toString()));
    }
}