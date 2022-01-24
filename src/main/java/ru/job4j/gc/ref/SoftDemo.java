package ru.job4j.gc.ref;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках
 * 0. Виды ссылок [#6854]
 * Soft Reference
 *
 * @author Dima_Nout
 * @since 24.01.2022
 */
public class SoftDemo {
    public static void main(String[] args) {
        example1();
        example2();
    }

    private static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        System.out.println(soft.get());
    }

    private static void example2() {
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            objects.add(new SoftReference<Object>(new Object() {
                String value = String.valueOf(System.currentTimeMillis());

                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            }));
        }
        System.gc();
        int liveObject = 0;
        for (SoftReference<Object> ref : objects) {
            Object object = ref.get();
            if (object != null) {
                liveObject++;
            }
        }
        System.out.println(liveObject);
    }

    /**
     * Не безопасный метод работы с Soft ссылкой.
     */
    private static void unsafe() {
        List<SoftReference<Object>> someData = new ArrayList<>();
        if (someData.get(0).get() != null) {
            Object object = someData.get(0).get();
        } else {
            someData.add(new SoftReference<Object>(new Object()));
        }
        someData.get(0).get();
    }

    /**
     * Безопасный способ работы с безопасной ссылкой.
     */
    private static void safe() {
        List<SoftReference<Object>> someData = new ArrayList<>();
        Object strong = someData.get(0).get();
        if (strong != null) {
            char ok = 'o';
        } else {
            char no = 'n';
        }
        System.out.println("Safe Soft Reference");
    }
}
