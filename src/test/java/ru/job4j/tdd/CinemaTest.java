package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.0. TDD
 * 2. Что такое TDD? [#4918]
 * Test. Cinema.
 *
 * @author Dima_Nout
 * @since 30.01.2022
 */
public class CinemaTest {
    @Ignore
    @Test
    public void whenBy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(List.of(new Session3D())));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenByEqualsTwoTicket() {
        Account account = new AccountCinema();
        Account account1 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.SEPTEMBER, 12, 21, 0);
        Ticket ticket = cinema.buy(account, 3, 3, date);
        Ticket ticket1 = cinema.buy(account1, 3, 3, date);
    }

    @Ignore
    @Test(expected = NoSuchElementException.class)
    public void whenByTicketDataFail() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(1945, Calendar.MAY, 9, 0, 43);
        Ticket ticket = cinema.buy(account, 5, 5, date);
    }

    @Ignore
    @Test(expected = NoSuchElementException.class)
    public void whenByTicketRowFail() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.SEPTEMBER, 12, 21, 0);
        Ticket ticket = cinema.buy(account, 100500, 3, date);
    }

    @Ignore
    @Test(expected = NoSuchElementException.class)
    public void whenByTicketColumnFail() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.SEPTEMBER, 12, 21, 0);
        Ticket ticket = cinema.buy(account, 7, 100500, date);
    }
}