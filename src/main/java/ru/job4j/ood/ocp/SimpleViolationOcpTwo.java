package ru.job4j.ood.ocp;

import java.util.Comparator;
import java.util.List;

/**
 * 2.5.2. OCP
 * 0. Принцип открытости закрытости [#4914].
 * Нарушение OCP 2. Метод sorter осуществляет сортировку List(User)
 * Для изменения способа сортировки правильно будет передавать компаратор в метод,
 * а не изменять каждый раз сам метод под определенные нужды.
 *
 * @author Dima_Nout
 * @since 03.02.2022.
 */
public class SimpleViolationOcpTwo {
    public void sorter(List<User> list) {
        list.sort(Comparator.comparing(User::getName));
    }

    private static class User {
        String name;
        Integer age;

        User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}
