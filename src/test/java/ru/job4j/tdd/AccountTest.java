package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.0. TDD
 * 2. Что такое TDD? [#4918]
 * Test. Account.
 *
 * @author Dima_Nout
 * @since 30.01.2022
 */
public class AccountTest {
    @Ignore
    @Test
    public void whenCreateAccount() {
        Account account = new AccountCinema();
        assertThat(account, is(new AccountCinema()));
    }
}