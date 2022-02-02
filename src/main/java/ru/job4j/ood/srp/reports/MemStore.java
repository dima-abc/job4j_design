package ru.job4j.ood.srp.reports;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 2.5.1. SRP
 * 1. Отчеты. [#850]
 * MemStore реализует интерфейс Store. Сохраняет результат в памяти.
 *
 * @author Dima_Nout
 * @since 02.02.2022
 */
public class MemStore implements Store<Employee> {
    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
