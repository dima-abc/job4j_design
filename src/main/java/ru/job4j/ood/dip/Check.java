package ru.job4j.ood.dip;

/**
 * 2.5.5. DIP
 * 0. Принцип инверсии зависимостей [#4917]
 * Пример. Модель Check.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.02.2022
 */
public class Check extends BaseEntity {
    public Check(int id, String name) {
        super(id, name);
    }
}
