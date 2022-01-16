package ru.job4j.gc;

/**
 * 2.4.1. Понятие сборщик мусора
 * 0. Понятие сборки мусора [#6851]
 * Модель данных Person.
 *
 * @author Dima_Nout.
 * @since 16.01.2022.
 */
public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", age, name);
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
}
