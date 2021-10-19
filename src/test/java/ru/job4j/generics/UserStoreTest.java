package ru.job4j.generics;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base> [#157 #127243]
 * Реализацию для пользователя. Test.
 *
 * @author Dmitry
 * @version 1
 * @since 19.10.2021
 */
public class UserStoreTest {

    @Test
    public void whenAdd() {
        UserStore userStor = new UserStore();
        User user1 = new User("Petr", "1");
        userStor.add(user1);
        assertThat(userStor.findById("1"), is(user1));
    }

    @Test
    public void whenReplaceTrue() {
        UserStore userStore = new UserStore();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        userStore.add(user1);
        assertTrue(userStore.replace("1", user2));
    }

    @Test
    public void whenReplaceFalse() {
        UserStore userStore = new UserStore();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        userStore.add(user1);
        assertFalse(userStore.replace("2", user2));
    }

    @Test
    public void whenDeleteTrue() {
        UserStore userStore = new UserStore();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        userStore.add(user1);
        userStore.add(user2);
        assertTrue(userStore.delete("2"));
    }

    @Test
    public void whenDeleteFalse() {
        UserStore userStore = new UserStore();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        userStore.add(user1);
        userStore.add(user2);
        assertFalse(userStore.delete("3"));
    }

    @Test
    public void whenFindByIdThenUser() {
        UserStore userStore = new UserStore();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        userStore.add(user1);
        userStore.add(user2);
        assertThat(userStore.findById("1"), is(user1));
    }

    @Test
    public void whenFindByIdThenNull() {
        UserStore userStore = new UserStore();
        User user1 = new User("Petr", "1");
        User user2 = new User("Dima", "2");
        userStore.add(user1);
        userStore.add(user2);
        assertNull(userStore.findById("3"));
    }
}