package ru.job4j.generics;

/**
 * 2.1.2. Generic
 * 0. Что такое обобщенные типы (generics) [#4952 #127242]
 *
 * @author Dmitry
 * @version 1
 * @since 18.10.2021
 */
public class Animal {
    private String name = "Животные.";

    @Override
    public String toString() {
        return "Animal{" + "name='"
                + name + '\'' + '}';
    }
}
