package ru.job4j.gc;

import java.util.Random;

/**
 * 2.4.2. Виды сборщиков мусора
 * 0. Виды сборщиков мусора [#6852]
 *
 * @author Dmitry
 * @since 18.01.2022
 */
public class GCTypeDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int length = 100;
        String[] data = new String[1_000_000];
        for (int i = 0; data[data.length - 1] == null; i = (i + 1) % data.length) {
            data[i] = String.valueOf(
                    (char) random.nextInt(255)
            ).repeat(length);
        }
    }
}
