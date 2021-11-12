package ru.job4j.collection.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
        int added = 0;
        int changed = 0;
        int deleted = 0;
        Map<User, User> userMap = setUserToMap(previous);
        for (User user : current) {
            Optional<User> mapUser = Optional.ofNullable(userMap.remove(user));
            if (mapUser.isPresent() && !user.getName().equals(mapUser.get().getName())) {
                changed++;
            }
        }
        deleted = userMap.size();
        added = deleted == 0 ? current.size() - previous.size() : 0;
        return new Info(added, changed, deleted);
    }

    private static Map<User, User> setUserToMap(Set<User> users) {
        Map<User, User> map = new HashMap<>();
        for (User user : users) {
            map.put(user, user);
        }
        return map;
    }
}
