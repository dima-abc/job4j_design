package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 2.1.2. Generic
 * 0. Что такое обобщенные типы (generics)[#4952 #127242]
 *
 * @author Dmitry
 * @version 1
 * @since 18.10.2021
 */
public class Generics {
    /**
     * Метод демонстрирует работу Generics
     *
     * @param args null
     */
    public static void main(String[] args) {
        Generics gen = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal());
        second.add(new Predator());
        third.add(new Tiger());

        gen.printObject(first);
        gen.printObject(second);
        gen.printObject(third);
        System.out.println();

        /**
         * ограничение сверху Animal выше Predator
         * gen.printBoundedWildCard(first);
         */
        gen.printBoundedWildCard(second);
        gen.printBoundedWildCard(third);
        System.out.println();

        gen.printLowerBoundedWildCard(first);
        gen.printLowerBoundedWildCard(second);
        /**
         * Ограничение сницу Tiger ниже Predator
         * gen.printLowerBoundedWildCard(third);
         */

    }

    /**
     * Работает без ограничений,
     * т.е. в него можно передавать коллекцию, которая хранит любые типы.
     * 1. WildCard.
     *
     * @param list Object
     */
    public void printObject(List<?> list) {
        for (Iterator<?> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    /**
     * Должен иметь ограничение сверху и ограничиваться классом Predator.
     * 2. Bounded Wildcard
     *
     * @param list extends Predator
     */
    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    /**
     * Должен иметь ограничение снизу и ограничиваться классом Predator
     * 3. Lower bounded Wildcard
     *
     * @param list super Predator
     */
    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }
}
