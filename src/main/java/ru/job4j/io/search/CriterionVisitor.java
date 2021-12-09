package ru.job4j.io.search;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 2.2.5. Контрольные вопросы
 * 2. Поиск файлов по критерию [#783 #127249]
 * Класс обходит файловую систему и собирает файлу по "Function<Path, Boolean>".
 *
 * @author Dmitry
 * @since 07.12.2021
 */
public class CriterionVisitor extends SimpleFileVisitor<Path> {
    final private Function<Path, Boolean> condition;
    final private List<Path> pathList = new ArrayList<>();

    public CriterionVisitor(Function<Path, Boolean> condition) {
        this.condition = condition;
    }

    public List<Path> getResult() {
        return this.pathList;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.apply(file)) {
            System.out.printf("File found: %s%n", file.toAbsolutePath().normalize());
            pathList.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
