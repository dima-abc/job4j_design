package ru.job4j.collection.question;

import java.util.Set;

/**
 * Collection
 * 2.1.7. Контрольные вопросы
 * 2. Статистика по коллекции. [#45889 #127233]
 * Базовый класс Analyze.
 *
 * @author Dmitry
 * @version 1
 * @since 11.11.2021
 */
public class Analyze {
    /**
     * Собирает статистику по двум коллекциям.
     *
     * @param previous Предыдущая.
     * @param current  Настоящая.
     * @return new Info.
     */
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = previous.size() < current.size() ? current.size() - previous.size() : 0;
        int deleted = previous.size() > current.size() ? previous.size() - current.size() : 0;
        return new Info(added, 0, deleted);
    }
}
