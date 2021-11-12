package ru.job4j.collection.question;

import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Collection
 * 2.1.7. Контрольные вопросы
 * 2. Статистика по коллекции. [#45889 #127233]
 * Test.
 *
 * @author Dmitry
 * @version 1
 * @since 11.11.2021
 */

public class AnalyzeTest {

    @Test
    public void whenDiffThenInfoNotModification() {
        Set<User> previous = Set.of(new User(1, "u1"),
                new User(2, "u2"),
                new User(3, "u3"));
        Set<User> current = Set.of(new User(1, "u1"),
                new User(2, "u2"),
                new User(3, "u3"));
        Info expected = new Info(0, 0, 0);
        assertThat(Analyze.diff(previous, current), is(expected));
    }

    @Test
    public void whenDiffInfoThenDellTwoElement() {
        Set<User> previous = Set.of(new User(1, "u1"),
                new User(2, "u2"),
                new User(3, "u3"));
        Set<User> current = Set.of(new User(1, "u1"));
        Info expected = new Info(0, 0, 2);
        assertThat(Analyze.diff(previous, current), is(expected));
    }

    @Test
    public void whenDiffInfoThenAddTwoElement() {
        Set<User> previous = Set.of(new User(1, "u1"),
                new User(2, "u2"),
                new User(3, "u3"));
        Set<User> current = Set.of(new User(1, "u1"),
                new User(2, "u2"),
                new User(3, "u3"),
                new User(4, "u4"),
                new User(5, "u5")
        );
        Info expected = new Info(2, 0, 0);
        assertThat(Analyze.diff(previous, current), is(expected));
    }

    @Test
    public void whenNotChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3);
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(0, 0, 0))
        );
    }

    @Test
    public void whenOneChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, new User(2, "BB"), u3);
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(0, 1, 0))
        );
    }

    @Test
    public void whenOneDeleted() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u3);
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(0, 0, 1))
        );
    }

    @Test
    public void whenOneAdded() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set<User> previous = Set.of(u1, u2, u3);
        Set<User> current = Set.of(u1, u2, u3, new User(4, "D"));
        assertThat(
                Analyze.diff(previous, current),
                is(new Info(1, 0, 0))
        );
    }
}