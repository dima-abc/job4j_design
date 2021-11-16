package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.function.BiPredicate;

/**
 * 2.2.1. Ввод-вывод
 * 2. Анализ доступности сервера.[#859#127261]
 *
 * @author Dmitry
 * @version 1
 * @since 16.11.2021
 */
public class Analizy {
    /**
     * Метод unavailable должен находить диапазоны, когда сервер не работал.
     *
     * @param source Путь к файлу лога.
     * @param target Путь к файлу результату анализа.
     */
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String start = "";
            String line;
            BiPredicate<String, String> error = (s, a) -> s.isEmpty()
                    && (a.equals("500") || a.equals("400"));
            BiPredicate<String, String> ok = (s, a) -> !s.isEmpty()
                    && (a.equals("200") || a.equals("300"));
            while ((line = in.readLine()) != null) {
                String[] event = line.split("\s", 2);
                if (error.test(start, event[0])) {
                    start = event[1];
                    continue;
                }
                if (ok.test(start, event[0])) {
                    out.printf("%s%s%s%n", start, ";", event[1]);
                    start = "";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        String source = "./data/analize/logServer.txt";
        String target = "./data/analize/unavailable.csv";
        analizy.unavailable(source, target);
    }
}
