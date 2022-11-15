package ru.job4j.gc.leak;

import ru.job4j.gc.leak.model.Comment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 2. Джуниор
 * 2.4. Garbage Collection
 * 2.4.3. Профилирование приложения
 * 2. Найти утечку памяти. [#504882]
 * Генератор комментариев.
 * Также при создании заполним список фразами,
 * а при вызове generate зачистим список,
 * а затем сгенерируем 50 комментариев из случайных фраз.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.11.2022
 */
public class CommentGenerator implements Generate {
    public static final String PATH_PHRASES = "src/main/java/ru/job4j/gc/leak/files/phrases.txt";
    public static final String SEPARATOR = System.lineSeparator();
    public static final Integer COUNT = 50;

    private final List<Comment> comments = new ArrayList<>();
    private final UserGenerator userGenerator;
    private final Random random;
    private List<String> phrases;

    public CommentGenerator(Random random, UserGenerator userGenerator) {
        this.random = random;
        this.userGenerator = userGenerator;
        read();
    }

    private void read() {
        try {
            this.phrases = read(PATH_PHRASES);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public void generate() {
        comments.clear();
        for (int i = 0; i < COUNT; i++) {
            String comment = String.join(SEPARATOR,
                    phrases.get(random.nextInt(phrases.size())),
                    phrases.get(random.nextInt(phrases.size())),
                    phrases.get(random.nextInt(phrases.size())));
            comments.add(new Comment(comment,
                    userGenerator.randomUser()));
        }
    }
}
