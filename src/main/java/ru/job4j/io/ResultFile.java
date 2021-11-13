package ru.job4j.io;

import java.io.FileOutputStream;
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
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i < 10; i++) {
                out.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
                for (int j = 1; j < 10; j++) {
                    String result = i + " x " + j + " = " + i * j;
                    out.write(result.getBytes(StandardCharsets.UTF_8));
                    out.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
