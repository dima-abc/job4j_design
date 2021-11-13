package ru.job4j.io;

import java.io.FileInputStream;

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
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
