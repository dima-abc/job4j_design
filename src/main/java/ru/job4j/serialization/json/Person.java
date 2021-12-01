package ru.job4j.serialization.json;

import java.util.Arrays;

/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * Модель данных Person.
 *
 * @author Dmitry
 * @since 01.12.2021
 */
public class Person {
    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statuses;

    public Person(boolean sex, int age, Contact contact, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{" + "sex=" + sex + ", age="
                + age + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses) + '}';
    }
}
