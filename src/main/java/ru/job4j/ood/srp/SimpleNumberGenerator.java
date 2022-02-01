package ru.job4j.ood.srp;

import java.util.Random;

/**
 * 2.5.1. SRP
 * 0. Принцип единственной ответственности [#4913]
 * Класс реализации одного числа.
 *
 * @author Dima_Nout
 * @since 01.02.2022.
 */
public class SimpleNumberGenerator implements NumberGenerator<Integer> {
    @Override
    public Integer generator() {
        Random random = new Random();
        return random.nextInt();
    }
}
