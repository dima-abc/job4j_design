package ru.job4j.ood.dip;

import java.util.Set;

/**
 * 2.5.5. DIP
 * 0. Принцип инверсии зависимостей [#4917]
 * Пример. Interface ShopStore описывает модель поведение хранилища сервиса.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.02.2022
 */
public interface ShopStore {
    boolean saveUser(User user);

    boolean saveOrder(User user, Order order);

    Set<Order> getOrders(User user);

    Set<User> getUsers();
}
