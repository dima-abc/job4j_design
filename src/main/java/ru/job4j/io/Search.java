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
 * 5. Валидация параметров запуска. [#246865 #127265]
 * Программу Search, ищет файлы только по определенному предикату.
 *
 * @author Dmitry
 * @version 1
 * @since 17.11.2021
 */
public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Param is null. Usage java -jar search.jar FOLDER SEARCH_PARAM");
        }
        Path start = Paths.get(args[0]);
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException("Param FOLDER is incorrect. Usage java -jar search.jar FOLDER SEARCH_PARAM");
        }
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    /**
     * Поиск файла по условию.
     *
     * @param root      Директория поиска
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
