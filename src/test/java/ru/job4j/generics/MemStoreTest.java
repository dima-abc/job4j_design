package ru.job4j.generics;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base> [#157 #127243]
 * Каркас универсального хранилища. Test.
 *
 * @author Dmitry
 * @version 1
 * @since 19.10.2021
 */
public class MemStoreTest {

    @Test
    public void whenAdd() {
        MemStore<User> mem = new MemStore<>();
        User user1 = new User("Petr", "1");
        mem.add(user1);
        assertThat(mem.findById("1"), is(user1));
    }

    @Test
    public void whenReplaceTrue() {
        MemStore<User> mem = new MemStore<>();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        mem.add(user1);
        assertTrue(mem.replace("1", user2));
    }

    @Test
    public void whenReplaceFalse() {
        MemStore<User> mem = new MemStore<>();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        mem.add(user1);
        assertFalse(mem.replace("2", user2));
    }

    @Test
    public void whenDeleteTrue() {
        MemStore<User> mem = new MemStore<>();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        mem.add(user1);
        mem.add(user2);
        assertTrue(mem.delete("2"));
    }

    @Test
    public void whenDeleteFalse() {
        MemStore<User> mem = new MemStore<>();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        mem.add(user1);
        mem.add(user2);
        assertFalse(mem.delete("3"));
    }

    @Test
    public void whenFindByIdThenUser() {
        MemStore<User> mem = new MemStore<>();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        mem.add(user1);
        mem.add(user2);
        assertThat(mem.findById("1"), is(user1));
    }

    @Test
    public void whenFindByIdThenNull() {
        MemStore<User> mem = new MemStore<>();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        mem.add(user1);
        mem.add(user2);
        assertNull(mem.findById("3"));
    }
}