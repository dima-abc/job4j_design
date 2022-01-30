package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.0. TDD
 * 2. Что такое TDD? [#4918]
 * Test. Session.
 *
 * @author Dima_Nout
 * @since 30.01.2022
 */
public class SessionTest {

    @Ignore
    @Test
    public void whenCreateSession() {
        Session session = new Session3D();
        assertThat(session, is(new Session3D()));
    }

}