package ru.job4j.io.duplicates;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 2.2.1. Ввод-вывод
 * 4.2. Поиск дубликатов [#315066]
 * Класс обхода дерева файловой системы.
 *
 * @author Dima_Nout
 * @version 1
 * @since 20.11.2021
 */
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> duplicates = new HashMap<>();

    /**
     * Метод отбирает дубликаты в списке найденных файлов
     *
     * @return Map.
     */
    public Map<FileProperty, List<Path>> getDuplicates() {
        return duplicates
                .keySet()
                .stream()
                .filter(k -> duplicates.get(k).size() > 1)
                .collect(Collectors.toMap(
                        k -> k,
                        k -> duplicates.get(k)
                ));
    }

    /**
     * Обход файловой системы
     *
     * @param file  Path
     * @param attrs BasicFileAttributes
     * @return File Attributes
     * @throws IOException exception
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (duplicates.containsKey(fileProperty)) {
            duplicates.get(fileProperty).add(file);
        } else {
            duplicates.put(fileProperty, new ArrayList<>());
            duplicates.get(fileProperty).add(file);
        }
        return super.visitFile(file, attrs);
    }
}
