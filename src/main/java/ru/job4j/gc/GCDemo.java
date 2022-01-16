package ru.job4j.gc;

/**
 * 2.4.1. Понятие сборщик мусора
 * 0. Понятие сборки мусора [#6851]
 * GCDemo.
 *
 * @author Dima_Nout.
 * @since 16.01.2022.
 */
public class GCDemo {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    private static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
        info();
        for (int i = 0; i < 10; i++) {
            new Person(i, "N" + i);
        }
        System.gc();
        info();
    }
}
