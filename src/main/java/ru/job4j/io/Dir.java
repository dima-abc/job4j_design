package ru.job4j.io;

import java.io.File;
import java.util.Objects;

/**
 * 2.2.1. Ввод-вывод
 * 4.0. File [#252491 #127263]
 *
 * @author Dmitry
 * @version 1
 * @since 16.11.2021
 */
public class Dir {
    public static void main(String[] args) {
        File file = new File("C:\\projects\\job4j_design");
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.printf("size : %s%n", file.getTotalSpace());
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            if (subfile.isFile()) {
                System.out.printf("File: %s - size %d Байт",
                                subfile.getName(), subfile.length());
            }
        }
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            if (subfile.isDirectory()) {
                System.out.printf("Directory: %s - size %d Байт",
                                subfile.getName(), subfile.length());
            }
        }
    }
}
