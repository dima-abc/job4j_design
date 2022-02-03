package ru.job4j.ood.srp.reports;

import java.util.Comparator;
import java.util.List;

import static java.util.Collections.*;

/**
 * 2.5.1. SRP
 * 1. Отчеты. [#850]
 * Генерация отчетов для HR.
 * Требуется исключить из отчета дату приема и дату увольнения,
 * и отсортировать в порядке убывания зарплаты.
 *
 * @author Dima_Nout
 * @since 02.02.2022
 */
public class HrGenerator implements ReportGenerator<Employee, String> {

    @Override
    public String generator(List<Employee> list) {
        list.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        StringBuilder text = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : list) {
            text.append(employee.getName()).append(";")
                    .append(String.format("%2f", employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
