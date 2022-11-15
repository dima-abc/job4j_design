package ru.job4j.gc.leak;

import ru.job4j.gc.leak.model.Post;

import java.util.Random;
import java.util.Scanner;

/**
 * 2. Джуниор
 * 2.4. Garbage Collection
 * 2.4.3. Профилирование приложения
 * 2. Найти утечку памяти. [#504882]
 * Меню. Так как задача стояла продемонстрировать утечку памяти,
 * реализацию удаления каждого поста по id пропустили.
 * Удаляем все сразу.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 16.11.2022
 */
public class Menu {
    public static final Integer ADD_POST = 1;
    public static final Integer ADD_MANY_POST = 2;
    public static final Integer SHOW_ALL_POSTS = 3;
    public static final Integer DELETE_POST = 4;

    public static final String SELECT = "Выберите меню";
    public static final String COUNT = "Выберите количество создаваемых постов";
    public static final String TEXT_OF_POST = "Введите текст";
    public static final String ID_FOR_DELETE = "Удаление всех постов";
    public static final String EXIT = "Конец работы";

    public static final String MENU = """
                Введите 1 для создание поста.
                Введите 2, чтобы создать определенное количество постов.
                Введите 3, чтобы показать все посты.
                Введите 4, чтобы удалить все посты.
                Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        Random random = new Random();
        UserGenerator userGenerator = new UserGenerator(random);
        CommentGenerator commentGenerator = new CommentGenerator(random, userGenerator);
        Scanner scanner = new Scanner(System.in);
        PostStore postStore = new PostStore();
        Menu menu = new Menu();
        menu.start(commentGenerator, scanner, postStore);
    }

    private void start(CommentGenerator commentGenerator, Scanner scanner, PostStore postStore) {
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            System.out.println(SELECT);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            if (ADD_POST == userChoice) {
                System.out.println(TEXT_OF_POST);
                String text = scanner.nextLine();
                createPost(commentGenerator, postStore, text);
            } else if (ADD_MANY_POST == userChoice) {
                System.out.println(TEXT_OF_POST);
                String text = scanner.nextLine();
                System.out.println(COUNT);
                String count = scanner.nextLine();
                for (int i = 0; i < Integer.parseInt(count); i++) {
                    createPost(commentGenerator, postStore, text);
                }
            } else if (SHOW_ALL_POSTS == userChoice) {
                postStore.getPosts()
                        .forEach(System.out::println);
            } else if (DELETE_POST == userChoice) {
                System.out.println(ID_FOR_DELETE);
                postStore.removeAll();
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }

    private void createPost(CommentGenerator commentGenerator, PostStore postStore, String text) {
        commentGenerator.generate();
        postStore.add(new Post(text, commentGenerator.getComments()));
    }
}
