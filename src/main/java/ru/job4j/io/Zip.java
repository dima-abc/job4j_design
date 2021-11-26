package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 2.2.1. Ввод-вывод
 * 5.2. Архивировать проект [#861 #127266]
 *
 * @author Dmitry
 * @version 1
 * @since 22.11.2021
 */
public class Zip {

    /**
     * Архивация списка фалов.
     *
     * @param sources Список файлов.
     * @param target  Имя архива.
     * @param root    Каталог архивирования.
     */
    public static void packFiles(List<Path> sources, Path target, Path root) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target.toFile())))) {
            int sizeDirect = root.toAbsolutePath().getNameCount() - 1;
            for (Path source : sources) {
                Path fileZip = source.subpath(sizeDirect, source.getNameCount());
                zip.putNextEntry(new ZipEntry(fileZip.toString()));
                System.out.printf("File package %s%n", source);
                try (BufferedInputStream in = new BufferedInputStream(
                        new FileInputStream(source.toFile()))) {
                    zip.write(in.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        Path root = Paths.get(argsName.get("d"));
        Path target = Paths.get(argsName.get("o"));
        String exclude = argsName.get("e");
        if (!root.toFile().isDirectory()) {
            throw new IllegalArgumentException("Folder package is not correct. Usage -d=DIRECTORY_FOLDER");
        }
        List<Path> sources = Search.search(root, p -> !p.toString().toLowerCase().endsWith(exclude));
        packFiles(sources, target, root);
    }
}
