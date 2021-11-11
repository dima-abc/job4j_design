package ru.job4j.collection.question;

/**
 * Collection
 * 2.1.7. Контрольные вопросы
 * 2. Статистика по коллекции. [#45889 #127233]
 * Модель Info.
 *
 * @author Dmitry
 * @version 1
 * @since 11.11.2021
 */
public class Info {
    /**
     * Сколько добавлено новых пользователей.
     * Добавленным считается такой пользователь,
     * что ранее его не было в множестве previous,
     * но в множестве current он есть.
     */
    private int added;
    /**
     * Сколько изменено пользователей.
     * Изменённым считается объект,
     * в котором изменилось имя,
     * а id осталось прежним.
     */
    private int changed;
    /**
     * Сколько удалено пользователей.
     * Удаленным считается такой пользователь,
     * что ранее он был в множестве previous,
     * но теперь в множестве current его нет.
     */
    private int deleted;

    public Info(int added, int changed, int deleted) {
        this.added = added;
        this.changed = changed;
        this.deleted = deleted;
    }
}
