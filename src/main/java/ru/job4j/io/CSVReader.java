package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * 2.2.1 Ввод-вывод.
 * 7. Scanner [#504791].
 * Задание: Создать класс CSVReader.
 * Класс читает файл СSV и фильтрует по заданным колонкам.
 * Содержимое выводится на консоль или в файл.
 *
 * @author Dima_Nout
 * @version 1
 * @since 29.11.2021.
 */
public class CSVReader {
    private List<String> values = new ArrayList<>();
    private Map<String, Integer> nameColumn = new HashMap<>();

    /**
     * Валидация входных параметров.
     *
     * @param argsName ArgsName.
     */
    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String filter = argsName.get("filter");
        if (!new File(path).isFile() || path.isEmpty()) {
            throw new IllegalArgumentException(
                    "Param -path is not correct. Usage -path=File.CSV");
        }
        if (!out.equals("stdout") && !new File(out).isFile()) {
            throw new IllegalArgumentException(
                    "Param -out is not correct. "
                            + "Usage -out=stdout for output to the console, "
                            + "or -out=File.CSV for output to file");
        }
        if (filter.isEmpty()) {
            throw new IllegalArgumentException(
                    "Param -filter is not correct. "
                            + "Usage -filter=COLUMN1,COLUMN2,...COLUMN3");
        }
        CSVReader csvReader = new CSVReader();
        csvReader.loadCSV(path, delimiter, filter);
        csvReader.stdOut(csvReader.values, out);
    }

    /**
     * Получаем список столбцов.
     * -delimiter=String.
     *
     * @param column    CSV Column.
     * @param delimiter CSV delimiter.
     */
    private void setColumn(String column, String delimiter) {
        int num = 0;
        for (String name : column.split(delimiter)) {
            this.nameColumn.put(name, num++);
        }
    }

    /**
     * Загружаем и фильтруем CSVFile
     *
     * @param path      FileCSV
     * @param delimiter String.
     * @param filter    String.
     */
    private void loadCSV(String path, String delimiter, String filter) {
        try (Scanner scanner = new Scanner(new File(path), StandardCharsets.UTF_8)) {
            String[] nameFilter = filter.split(",");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(delimiter);
                if (this.nameColumn.isEmpty()) {
                    setColumn(line, delimiter);
                }
                StringJoiner joiner = new StringJoiner(delimiter);
                for (String name : nameFilter) {
                    joiner.add(values[nameColumn.get(name)]);
                }
                this.values.add(joiner.toString());
                this.values.add(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Вывод результата на консоль
     * -out=stdout
     * -out=File
     *
     * @param list List.
     * @param path String
     */
    public void stdOut(List<String> list, String path) throws IOException {
        if (path.equals("stdout")) {
            list.forEach(System.out::print);
            return;
        }
        try (PrintWriter out = new PrintWriter(
                new FileWriter(path, StandardCharsets.UTF_8, true))) {
            list.forEach(out::print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        CSVReader.handle(argsName);
    }
}
