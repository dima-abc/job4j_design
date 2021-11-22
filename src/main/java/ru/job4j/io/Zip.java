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
    public static void packFiles(List<File> sources, File target) {
        sources.forEach(s -> packSingleFile(s, target));
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        List<Path> sources = Search.search(Paths.get(argsName.get("d")), e -> !e.endsWith(argsName.get("e")));
        packSingleFile(new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}
