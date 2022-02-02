package ru.job4j.ood.srp.reports;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.1. SRP
 * 1. Отчеты. [#850]
 * Класс генерации отчета.
 * Test.
 *
 * @author Dima_Nout
 * @since 02.02.2022
 */
public class ReportEngineTest {
    @Test
    public void whenAccountantGenerator() {
        MemStore store = new MemStore();
        ReportGenerator<Employee, String> generator = new AccountantGenerator();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100D);
        store.add(worker);
        Report<Employee, String> engine = new ReportEngine(store, generator);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getDateFormat().format(worker.getHired().getTime())).append(";")
                .append(worker.getDateFormat().format(worker.getFired().getTime())).append(";")
                .append(String.format("%.2f", worker.getSalary() / 120 * 100)).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHrGenerator() {
        MemStore store = new MemStore();
        ReportGenerator<Employee, String> generator = new HrGenerator();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100D);
        Employee worker2 = new Employee("Eva", now, now, 200D);
        store.add(worker);
        store.add(worker2);
        Report<Employee, String> engine = new ReportEngine(store, generator);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(String.format("%2f", worker2.getSalary())).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(String.format("%2f", worker.getSalary())).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenProgrammerGenerator() {
        MemStore store = new MemStore();
        ReportGenerator<Employee, String> generator = new ProgrammerGenerator();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100D);
        store.add(worker);
        Report<Employee, String> engine = new ReportEngine(store, generator);
        StringBuilder expect = new StringBuilder()
                .append("<table border=\"1\" bordercolor=\"black\">")
                .append("<tr><th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th></tr>")
                .append("<tr>")
                .append("<td>").append(worker.getName()).append("</td>")
                .append("<td>").append(worker.getDateFormat().format(worker.getHired().getTime())).append("</td>")
                .append("<td>").append(worker.getDateFormat().format(worker.getFired().getTime())).append("</td>")
                .append("<td>").append(String.format("%2f", worker.getSalary())).append("</td>")
                .append("</tr>")
                .append("</table>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}