package ru.job4j.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 * Класс создает ввод с консоли.
 *
 * @author Dima_Nout
 * @since 26.01.2022.
 */
public class ConsoleInput implements Input {
    private static final Logger LOG = LoggerFactory.getLogger(ConsoleInput.class.getName());
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод для ввода строки.
     *
     * @param question String
     * @return String
     */
    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Метод для ввода цифры.
     *
     * @param question String
     * @return int
     */
    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.parseInt(askStr(question));
                invalid = false;
            } catch (NumberFormatException nfe) {
                LOG.error("Please enter validate data again", nfe);
            }
        } while (invalid);
        return value;
    }
}
