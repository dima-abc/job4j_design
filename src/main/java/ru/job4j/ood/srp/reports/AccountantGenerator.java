package ru.job4j.ood.srp.reports;

import java.util.List;

/**
 * 2.5.1. SRP
 * 1. Отчеты. [#850]
 * Генерация отчета для бухгалтерии.
 * Требования формировать отчет с измененной зарплатой,
 * в данном случае применил вывод зарплаты без НДС.
 *
 * @author Dima_Nout
 * @since 02.02.2022
 */
public class AccountantGenerator implements ReportGenerator<Employee, String> {
    @Override
    public String generator(List<Employee> list) {
        StringBuilder text = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : list) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired().getTime()).append(";")
                    .append(employee.getFired().getTime()).append(";")
                    .append(String.format("%.2f", nds(employee.getSalary()))).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    /**
     * Пересчет зарплаты в сумму без НДС
     *
     * @param salary Salary
     * @return Salary - NDS
     */
    private Double nds(Double salary) {
        return salary / 120 * 100;
    }
}
