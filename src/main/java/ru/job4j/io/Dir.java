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
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    String.format("Not exist %s%n", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Not directory %s%n", file.getAbsoluteFile()));
        }
        System.out.printf("size : %s%n", file.getTotalSpace());
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            if (subfile.isFile()) {
                System.out.printf("File: %s - size %d Байт%n",
                        subfile.getName(), subfile.length());
            }
        }
        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            if (subfile.isDirectory()) {
                System.out.printf("Directory: %s - size %d Байт%n",
                        subfile.getName(), subfile.length());
            }
        }
    }
}
