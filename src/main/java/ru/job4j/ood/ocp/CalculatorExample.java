package ru.job4j.ood.ocp;

import java.util.function.BiFunction;

/**
 * 2.5.2. OCP
 * 0. Принцип открытости закрытости [#4914].примеры.
 *
 * @author Dima_Nout
 * @since 03.02.2022
 */
public class CalculatorExample {
    /**
     * Нарушение OCP, для расширения потребуется изменить сам класс.
     */
    private static class SimpleCalculator {
        public int sum(int a, int b) {
            return a + b;
        }
    }

    /**
     * Не нарушает OCP. Для изменения функции достаточно передать другую функцию,
     * при этом изменение класса не требуется.
     *
     * @param <T>
     */
    private static class AbstractCalculator<T> {
        public T calculator(BiFunction<T, T, T> function, T first, T second) {
            return function.apply(first, second);
        }
    }
}
