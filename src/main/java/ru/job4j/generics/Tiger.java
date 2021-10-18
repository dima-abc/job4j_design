package ru.job4j.generics;

/**
 * 2.1.2. Generic
 * 0. Что такое обобщенные типы (generics) [#4952 #127242]
 *
 * @author Dmitry
 * @version 1
 * @since 18.10.2021
 */
public class Tiger extends Predator {
    private String name = "Тигры.";

    @Override
    public String toString() {
        return "Tiger{" + "name='"
                + name + '\'' + '}';
    }
}
