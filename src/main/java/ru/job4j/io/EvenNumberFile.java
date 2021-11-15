package ru.job4j.io;

import java.io.FileInputStream;

/**
 * 2.2.1. Ввод-вывод
 * 0.2. FileInputStream [#4898 #127256]
 * Задача.
 *
 * @author Dima_Nout
 * @version 1
 * @since 14.11.2021
 */
public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("./data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] numbers = text.toString().split(System.lineSeparator());
            for (String number : numbers) {
                int temp = Integer.parseInt(number);
                if (temp % 2 == 0) {
                    System.out.println(temp + " четное");
                    continue;
                }
                System.out.println(temp + " не четное");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
