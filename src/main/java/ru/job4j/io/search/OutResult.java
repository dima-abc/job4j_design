package ru.job4j.io.search;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

/**
 * 2.2.5. Контрольные вопросы
 * 2. Поиск файлов по критерию [#783 #127249]
 * Сохранение результата в файл.
 *
 * @author Dmitry
 * @since 07.12.2021
 */
public class OutResult {
    /**
     * Метод сохраняет список фалов в Файл.
     *
     * @param pathList List.
     * @param file     Path.
     */
    public void saveFile(List<Path> pathList, Path file) {
        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file.toFile(), StandardCharsets.UTF_8)))) {
            pathList.forEach(p -> writer.println(p.toAbsolutePath().normalize()));
            System.out.printf("File save: %s%n", file.toAbsolutePath().normalize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
