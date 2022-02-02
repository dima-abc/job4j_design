package ru.job4j.ood.srp.reports;

import java.util.List;
import java.util.function.Predicate;

/**
 * 2.5.1. SRP
 * 1. Отчеты. [#850]
 * Интерфейс доступа к базе данных.
 *
 * @param <T> Type
 * @author Dima_Nout
 * @since 02.02.2022
 */
public interface Store<T> {
    List<T> findBy(Predicate<T> filter);
}
