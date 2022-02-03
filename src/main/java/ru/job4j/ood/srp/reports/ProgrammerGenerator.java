package ru.job4j.ood.srp.reports;

import java.util.List;

/**
 * 2.5.1. SRP
 * 1. Отчеты. [#850]
 * Генерация отчета для программистов.
 * Требуется вывод в формате HTML.
 *
 * @author Dima_Nout
 * @since 02.02.2022
 */
public class ProgrammerGenerator implements ReportGenerator<Employee, String> {
    @Override
    public String generator(List<Employee> list) {
        StringBuilder html = new StringBuilder()
                .append("<table border=\"1\" bordercolor=\"black\">")
                .append("<tr><th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th></tr>");
        for (Employee employee : list) {
            html.append("<tr>")
                    .append("<td>").append(employee.getName()).append("</td>")
                    .append("<td>").append(employee.getHired().getTime()).append("</td>")
                    .append("<td>").append(employee.getFired().getTime()).append("</td>")
                    .append("<td>").append(String.format("%2f", employee.getSalary())).append("</td>")
                    .append("</tr>");

        }
        html.append("</table>");
        return html.toString();
    }
}
