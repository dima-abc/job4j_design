package ru.job4j.ood.srp;

import java.util.List;

/**
 * 2.5.1. SRP
 * 0. Принцип единственной ответственности [#4913]
 * Интерфейс генерации.
 *
 * @author Dima_Nout
 * @since 01.02.2022.
 */
public interface SequenceGenerator<T> {
    List<T> generate(int size);
}
