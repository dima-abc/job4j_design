package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * 2.2.1. Ввод-вывод
 * 4.2. Поиск дубликатов [#315066]
 * Основной класс поиска дубликатов файлов в заданном каталоге.
 *
 * @author Dima_Nout
 * @version 1
 * @since 20.11.2021
 */
public class DuplicatesFinder {
    /**
     * Метод выполнения программы.
     *
     * @param args String[].
     * @throws IOException Exception.
     */
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("..");
        searchDuplicate(start).forEach((k, v) -> {
            System.out.printf("File name: %s; size %d Bait %n", k.getName(), k.getSize());
            v.forEach(p -> System.out.println(p.toAbsolutePath().normalize()));
        });
    }

    /**
     * Метод обходит все каталоги
     * и собирает дубликаты файлов в коллекцию Map.
     *
     * @param root Каталог поиска.
     * @return Map
     * @throws IOException Exception
     */
    public static Map<FileProperty, List<Path>> searchDuplicate(Path root) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(root, duplicatesVisitor);
        return duplicatesVisitor.getDuplicates();
    }
}
