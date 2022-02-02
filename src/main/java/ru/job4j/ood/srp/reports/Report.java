package ru.job4j.ood.srp.reports;

import java.util.function.Predicate;

/**
 * 2.5.1. SRP
 * 1. Отчеты. [#850]
 * Интерфейс генерации отчетов.
 *
 * @param <T> Type
 * @param <E> Element
 * @author Dima_Nout
 * @since 02.02.2022
 */
public interface Report<T, E> {
    E generate(Predicate<T> filter);
}
