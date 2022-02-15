package ru.job4j.ood.dip.simple;

import java.util.Objects;

/**
 * 2.5.5. DIP
 * 0. Принцип инверсии зависимостей [#4917]
 * Задание. Пример нарушения DIP.
 * Модель данных Student.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.02.2022
 */
public class StudentSimpleFoulDIP {
    private int id;
    public String name;

    public StudentSimpleFoulDIP(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentSimpleFoulDIP that = (StudentSimpleFoulDIP) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
