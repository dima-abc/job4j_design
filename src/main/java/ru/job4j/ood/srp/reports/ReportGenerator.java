package ru.job4j.ood.srp.reports;

import java.util.List;

/**
 * /**
 * 2.5.1. SRP
 * 1. Отчеты. [#850]
 * Интерфейс генерации записи отчета.
 *
 * @param <T> Type
 * @param <E> Element
 * @author Dima_Nout
 * @since 02.02.2022
 */
public interface ReportGenerator<T, E> {
    E generator(List<T> list);
}
