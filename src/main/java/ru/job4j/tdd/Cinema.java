package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.5.0. TDD
 * 2. Что такое TDD? [#4918]
 * Интерфейс кинотеатр.
 *
 * @author Dima_Nout
 * @since 30.01.2022
 */
public interface Cinema {
    /**
     * Поиск сеансов
     *
     * @param filter Predicate.
     * @return List
     */
    List<Session> find(Predicate<Session> filter);

    /**
     * Покупка билетов.
     *
     * @param account Account
     * @param row     Ряд.
     * @param column  Место.
     * @param date    Дата сеанса.
     * @return Ticket.
     */
    Ticket buy(Account account, int row, int column, Calendar date);

    /**
     * Добавление сеанса.
     *
     * @param session Session.
     */
    void add(Session session);
}
