package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

/**
 * 2.2.1. Ввод-вывод
 * 5.1. Именованные аргументы [#295518]
 *
 * @author Dima_Nout
 * @version 1
 * @since 21.11.2021
 */
public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    /**
     * Делаем недоступны конструктор по умолчанию.
     */
    private ArgsName() {
    }

    /**
     * Метод возвращает значение параметра по ключу.
     *
     * @param key Параметр.
     * @return Значение.
     */
    public String get(String key) {
        return values.get(key);
    }

    /**
     * Собираем парамер значение в Map values.
     *
     * @param args String[].
     */
    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Parameters is empty. Enter parameters.");
        }
        for (String arg : args) {
            String[] param = arg.split("=");
            if (param.length != 2) {
                throw new IllegalArgumentException("Parameter is not correct. Usage -key=value");
            }
            param[0] = param[0].replaceFirst("-", "");
            values.put(param[0], param[1]);
        }
    }

    /**
     * Создаем объект и собираем набок параметр значение.
     *
     * @param args String[].
     * @return ArgsName.
     */
    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
