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
        int deleted;
        Map<User, User> userMap = toMapSetUser(previous);
        for (User user : current) {
            Optional<User> mapUser = Optional.ofNullable(userMap.remove(user));
            if (mapUser.isPresent() && !user.getName().equals(mapUser.get().getName())) {
                changed++;
            }
            if (mapUser.isEmpty()) {
                added++;
            }
        }
        deleted = userMap.size();
        return new Info(added, changed, deleted);
    }

    /**
     * Помещает Set(User) в Map(User,User).
     *
     * @param users Set(User)
     * @return Map(User, User)
     */
    private static Map<User, User> toMapSetUser(Set<User> users) {
        Map<User, User> map = new HashMap<>();
        for (User user : users) {
            map.put(user, user);
        }
        return map;
    }
}
