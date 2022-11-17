package ru.job4j.gc.leak;

import ru.job4j.gc.leak.model.Comment;
import ru.job4j.gc.leak.model.Post;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2. Джуниор
 * 2.4. Garbage Collection
 * 2.4.3. Профилирование приложения
 * 2. Найти утечку памяти. [#504882]
 * Хранилище постов.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.11.2022
 */
public class PostStore {
    private final Map<Integer, Post> posts = new HashMap<>();
    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public Post add(Post post) {
        Integer id = atomicInteger.decrementAndGet();
        post.setId(id);
        posts.put(id, post);
        return post;
    }

    public void removeAll() {
        posts.values()
                .forEach(post -> post.getComments().clear());
        posts.clear();
    }

    public Collection<Post> getPosts() {
        return posts.values();
    }
}
