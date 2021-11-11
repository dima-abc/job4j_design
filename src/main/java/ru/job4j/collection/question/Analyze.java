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

    public static Info diff(Set<User> previous, Set<User> current) {
        return new Info(0, 0, 0);
    }
}
