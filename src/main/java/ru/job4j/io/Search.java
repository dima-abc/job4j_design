package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.2.1. Ввод-вывод
 * 4.1. Сканирование файловой системы. [#106929 #127264]
 * Пример. Задача.
 *
 * @author Dmitry
 * @version 1
 * @since 17.11.2021
 */
public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, p -> p.toFile().getName().endsWith("js")).forEach(System.out::println);
    }

    /**
     * Поиск файла по условию.
     *
     * @param root Директория поиска
     * @param condition Условия поиска
     * @return List
     * @throws IOException throws IO
     */
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
