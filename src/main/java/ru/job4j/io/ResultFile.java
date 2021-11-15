package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 2.2.1.Ввод-вывод
 * 0.1.FileOutputStream.[#252488#127255]
 *
 * @author Dima_Nout.
 * @version 1.
 * @since 14.11.2021.
 */
public class ResultFile {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("result.txt")
                ))) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    out.printf("%d X %d = %d%n", i, j, i * j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
