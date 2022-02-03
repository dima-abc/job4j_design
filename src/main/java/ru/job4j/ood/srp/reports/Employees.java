package ru.job4j.ood.srp.reports;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 2.5.2. OCP
 * 1. Поддержка форматом XML, JSON в генераторе отчетов. [#851]
 *
 * @author Dima_Nout
 * @since 04.02.2022
 */
@XmlRootElement(name = "employees")
public class Employees {
    private List<Employee> employees;

    public Employees() {
    }

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
