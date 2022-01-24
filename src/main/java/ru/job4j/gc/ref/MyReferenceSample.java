package ru.job4j.gc.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках
 * 0. Виды ссылок [#6854]
 * Cвой пример, как нужно безопасно работать с SoftReference и WeakReference.
 *
 * @author Dima_Nout
 * @since 24.01.2022
 */
public class MyReferenceSample {
    /**
     * Пример SoftReference
     */
    private static void softSafeSample() {
        SoftReference<String> softString = new SoftReference<>("May soft reference safe");
        String string = softString.get();
        if (string != null) {
            System.out.println(string);
        } else {
            System.out.println("softReference is Null");
        }
    }

    /**
     * Пример WeakReference.
     */
    private static void weakSafeSample() {
        WeakReference<Integer> weakInt = new WeakReference<>(2022);
        Integer integer = weakInt.get();
        if (integer != null) {
            System.out.println("WeakReference " + integer);
        } else {
            System.out.println("Weak reference is null");
        }
    }
}
