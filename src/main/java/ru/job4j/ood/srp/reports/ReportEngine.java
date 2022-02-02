package ru.job4j.ood.srp.reports;

import java.util.function.Predicate;

/**
 * 2.5.1. SRP
 * 1. Отчеты. [#850]
 * Класс генерации отчета.
 *
 * @author Dima_Nout
 * @since 02.02.2022
 */
public class ReportEngine implements Report<Employee, String> {
    private Store<Employee> store;
    private ReportGenerator<Employee, String> generator;

    public ReportEngine(Store<Employee> store, ReportGenerator<Employee, String> generator) {
        this.store = store;
        this.generator = generator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return generator.generator(store.findBy(filter));
    }
}
