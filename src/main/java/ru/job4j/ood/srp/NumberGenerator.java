package ru.job4j.ood.srp;

/**
 * 2.5.1. SRP
 * 0. Принцип единственной ответственности [#4913]
 * Интерфейс генерации одного значения.
 *
 * @author Dima_Nout
 * @since 01.02.2022.
 */
public interface NumberGenerator<T> {
    T generator();
}
