package ru.job4j.ood.srp.reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 * 2.5.1. SRP
 * 1. Отчеты. [#850]
 * Модель данных Employee
 *
 * @author Dima_Nout
 * @since 02.02.2022
 */
public class Employee {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;
    private DateFormat dateFormat = new SimpleDateFormat("dd MM yy");

    public Employee(String name, Calendar hired, Calendar fired, Double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Calendar getHired() {
        return hired;
    }

    public Employee setHired(Calendar hired) {
        this.hired = hired;
        return this;
    }

    public Calendar getFired() {
        return fired;
    }

    public Employee setFired(Calendar fired) {
        this.fired = fired;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
