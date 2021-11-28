package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        String path = argsName.get("-path");
        String out = argsName.get("-out");
        String filter = argsName.get("-filter");
        if (!new File(path).isFile()) {
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
            String value = name.toUpperCase();
            this.nameColumn.put(value, num++);
        }
    }

    /**
     * Создаем массив столбцов Filter и добавляем в values.
     * -filter=a,b...,n.
     *
     * @param filter String.
     * @return Filter[].
     */
    private String[] addColumnFilter(String filter) {
        String[] result = filter.toUpperCase().split(",");
        for (String name : result) {
            if (!this.nameColumn.containsKey(name)) {
                throw new IllegalArgumentException("Param -filter is not correct. "
                        + "Usage -filter=COLUMN1,COLUMN2,...COLUMN3");
            }
            this.values.add(name);
        }
        this.values.add(System.lineSeparator());
        return result;
    }

    /**
     * Загружаем и фильтруем CSVFile
     *
     * @param path      FileCSV
     * @param delimiter String.
     * @param filter    String.
     */
    private void loadCSV(File path, String delimiter, String filter) {
        try (Scanner scanner = new Scanner(path)) {
            setColumn(scanner.nextLine(), delimiter);
            String[] nameFilter = addColumnFilter(filter);
            while (scanner.hasNextLine()) {
                String[] value = scanner.nextLine().split(delimiter);
                StringJoiner joiner = new StringJoiner(delimiter);
                for (String name : nameFilter) {
                    joiner.add(value[nameColumn.get(name)]);
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
     *
     * @param list List.
     */
    public void stdOut(List<String> list) {
        list.forEach(System.out::print);
    }

    /**
     * Вывод результата в файл.
     * -out=FileName
     *
     * @param list List
     * @param path File
     */
    public void stdOut(List<String> list, String path) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(path, StandardCharsets.UTF_8, true))) {
            list.forEach(out::print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
