package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * 2.2.1.Ввод-вывод
 * 0.2. FileInputStream [#4898 #127256]
 * Пример.
 *
 * @author Dima_Nout
 * @version 1
 * @since 14.11.2021
 */
public class ReadFile {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("./data/input.txt"))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
