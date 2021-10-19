package ru.job4j.generics;

/**
 * 2.1.2. Generic
 * 5.2.2. Реализовать Store<T extends Base> [#157 #127243]
 * Реализацию для пользователя.
 * Будем использовать композицию объектов.
 *
 * @author Dmitry
 * @version 1
 * @since 19.10.2021
 */
public class UserStore implements Store<User> {
    private Store<User> user = new MemStore<>();

    @Override
    public void add(User model) {
        user.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return user.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return user.delete(id);
    }

    @Override
    public User findById(String id) {
        return user.findById(id);
    }
}
