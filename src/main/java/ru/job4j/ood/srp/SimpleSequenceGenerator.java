package ru.job4j.ood.srp;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 2.5.1. SRP
 * 0. Принцип единственной ответственности [#4913]
 * Класс реализации генерации списка чисел.
 *
 * @author Dima_Nout
 * @since 01.02.2022.
 */
public class SimpleSequenceGenerator implements SequenceGenerator<Integer> {
    private final NumberGenerator<Integer> numberGenerator;

    public SimpleSequenceGenerator(NumberGenerator<Integer> numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public List<Integer> generate(int size) {
        return IntStream.range(0, size)
                .map(i -> numberGenerator.generator())
                .boxed()
                .collect(Collectors.toList());
    }
}
