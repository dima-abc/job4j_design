package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2.2.1. Ввод-вывод
 * 0.3. BufferedReader.[#252489#127258]
 *
 * @author Dima_Nout
 * @version 1
 * @since 14.11.2021
 */
public class LogFilter {
    /**
     * Метод filter должен прочитать файл
     * и вернуть строки, где предпоследнее значение - это 404.
     *
     * @param file Name File
     * @return List
     */
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            result = in.lines()
                    .filter(l -> l.contains("\" 404 "))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> logs = filter("log.txt");
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
