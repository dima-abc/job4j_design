package ru.job4j.io.search;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
                new BufferedOutputStream(
                        new FileOutputStream(file.toFile())))) {
            pathList.forEach(p -> writer.println(p.toAbsolutePath().normalize()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
