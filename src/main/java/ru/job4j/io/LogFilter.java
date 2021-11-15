package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2.2.1. Ввод-вывод
 * 0.3. BufferedReader.[#252489#127258]
 * 0.4. BufferedOutputStream [#252490 #127259]
 *
 * @author Dima_Nout
 * @version 1
 * @since 15.11.2021
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

    /**
     * Записывает результат фильтрации в файл.
     * @param log List.
     * @param file File name.
     */
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String line : log) {
                out.printf("%s%n", line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> logs = filter("./data/log.txt");
        save(logs, "./data/404.txt");
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
