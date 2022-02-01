package ru.job4j.ood.srp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 2.5.1. SRP
 * 0. Принцип единственной ответственности [#4913]
 * Пример 1. Класс содержит различный функционал так же нарушает ISP,
 * Читает файл, пишет в файл, печатает строку.
 *
 * @author Dima_Nout
 * @since 01.02.2022
 */
public class SimpleViolationRspFirst {
    public String load(String file) {
        String result = "";
        try {
            result = Files.readString(Path.of(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void save(String str, String file) {
        try {
            Files.writeString(Path.of(file), str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(String str) {
        System.out.print(str);
    }
}
