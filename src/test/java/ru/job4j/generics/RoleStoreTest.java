package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base> [#157 #127243]
 * Реализацию для магазинов. Test.
 *
 * @author Dmitry
 * @version 1
 * @since 19.10.2021
 */
public class RoleStoreTest {

    @Test
    public void whenAdd() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("Shop", "1");
        roleStore.add(role1);
        assertThat(roleStore.findById("1"), is(role1));
    }

    @Test
    public void whenReplaceTrue() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("Shop", "1");
        Role role2 = new Role("Market", "2");
        roleStore.add(role1);
        assertTrue(roleStore.replace("1", role2));
    }

    @Test
    public void whenReplaceFalse() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("Shop", "1");
        Role role2 = new Role("Market", "2");
        roleStore.add(role1);
        assertFalse(roleStore.replace("2", role2));
    }

    @Test
    public void whenDeleteTrue() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("Shop", "1");
        Role role2 = new Role("Market", "2");
        roleStore.add(role1);
        roleStore.add(role2);
        assertTrue(roleStore.delete("2"));
    }

    @Test
    public void whenDeleteFalse() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("Shop", "1");
        Role role2 = new Role("Market", "2");
        roleStore.add(role1);
        roleStore.add(role2);
        assertFalse(roleStore.delete("3"));
    }

    @Test
    public void whenFindByIdThenRole() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("Shop", "1");
        Role role2 = new Role("Market", "2");
        roleStore.add(role1);
        roleStore.add(role2);
        assertThat(roleStore.findById("1"), is(role1));
    }

    @Test
    public void whenFindByIdThenNull() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("Shop", "1");
        Role role2 = new Role("Market", "2");
        roleStore.add(role1);
        roleStore.add(role2);
        assertNull(roleStore.findById("3"));
    }
}