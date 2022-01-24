package ru.job4j.gc.ref;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках
 * 0. Виды ссылок [#6854]
 * Strong Reference
 *
 * @author Dima_Nout
 * @since 24.01.2022
 */
public class StrongDemo {
    public static void main(String[] args) throws InterruptedException {
        example1();
        example2();
        example3();
    }

    /**
     * Создаем объекты и далее их за'null'яем.
     * Вызываем сборщик мусора System.gc().
     * Объекты удаляются так как ссылки на них null.
     *
     * @throws InterruptedException exception
     */
    private static void example1() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            objects[i] = new Object() {
                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            };
        }
        for (int i = 0; i < 100; i++) {
            objects[i] = null;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * Создаем объекты вместе с вложенным.
     * Удаляя внешние объекты как в примере выше удаляются и вложенные,
     * не смотря на то что они не null.
     *
     * @throws InterruptedException exception.
     */
    private static void example2() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            Object object = new Object() {
                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Remove inner object!");
                }
            };
            objects[i] = object;
        }
        for (int i = 0; i < 100; i++) {
            objects[i] = null;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * Проблема с неиспользуемыми ссылками в Strong Reference
     * такие объекты не будут удалены.
     * Пример кода с OutOfMemoryError.
     */
    private static void example3() {
        List<String> string = new ArrayList<>();
        while (true) {
            string.add(String.valueOf(System.currentTimeMillis()));
        }
    }
}
