package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 2.2.1. Ввод-вывод.
 * 1. Читаем файл конфигурации [#858 #127260].
 *
 * @author Dmitry
 * @version 1
 * @since 15.11.2021
 */
public class Config {
    private final String path;
    private final Map<String, String> value = new HashMap<>();

    /**
     * Конструктор принимает путь к файлу и его имя.
     *
     * @param path Path file.
     */
    public Config(String path) {
        this.path = path;
    }

    /**
     * Считывает все ключи в карту values.
     * Важно в файле могут быть пустые строки и комментарии их нужно пропускать.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                if (!line.startsWith("#") && line.contains("=")) {
                    String[] params = line.split("\s?[=]\s?");
                    this.value.put(params[0], params[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.value.containsKey("")) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Возвращает значение по ключу.
     *
     * @param key Key.
     * @return Value.
     */
    public String value(String key) {
        return value.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("./data/config/app.properties"));
    }
}
