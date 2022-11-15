package ru.job4j.gc.leak.model;

import java.util.Objects;

/**
 * 2. Джуниор
 * 2.4. Garbage Collection
 * 2.4.3. Профилирование приложения
 * 2. Найти утечку памяти. [#504882]
 * Модель данных Comment.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.11.2022
 */
public class Comment {
    private String text;
    private User user;

    public Comment(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment = (Comment) o;
        return Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "Comment{text='" + text + '\'' + ", user=" + user + '}';
    }
}
