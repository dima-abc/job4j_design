package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * 2.2.1. Ввод-вывод
 * 4.1. Сканирование файловой системы. [#106929 #127264]
 * Задача.
 *
 * @author Dmitry
 * @version 1
 * @since 17.11.2021
 */
public class SearchFiles implements FileVisitor<Path> {
    /**
     * Условие для поиска файла.
     */
    private Predicate<Path> condition;
    private List<Path> listFiles = new ArrayList<>();

    public SearchFiles(Predicate<Path> condition) {
        this.condition = condition;
    }

    /**
     * Возвращает список найденных файлов.
     *
     * @return List.
     */
    public List<Path> getPaths() {
        return listFiles;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (this.condition.test(file)) {
            this.listFiles.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }
}
