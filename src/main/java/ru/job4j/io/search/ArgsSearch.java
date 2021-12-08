package ru.job4j.io.search;

import java.util.HashMap;
import java.util.Map;

/**
 * 2.2.5. Контрольные вопросы
 * 2. Поиск файлов по критерию [#783 #127249]
 * Сбор и обработка параметров запуска.
 *
 * @author Dmitry
 * @since 07.12.2021
 */
public class ArgsSearch {
    final private Map<String, String> values = new HashMap<>();

    /**
     * Делаем недоступным конструктор по умолчанию.
     */
    private ArgsSearch() {
    }

    /**
     * Собираем параметры в Map.
     *
     * @param args String[].
     */
    private void parse(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Enter the missing parameters."
                    + "Format: -d=DIRECTORY -n=NAME_SEARCH -t=SEARCH_PARAM -o=SAVE_FILE_RESULT.TXT");
        }
        for (String arg : args) {
            String[] param = arg.split("=");
            if (param.length != 2) {
                throw new IllegalArgumentException("Parameter is not correct. Usage -key=value");
            }
            param[0] = param[0].replaceFirst("-", "");
            this.values.put(param[0], param[1]);
        }
    }

    /**
     * Возвращаем параметры по ключу.
     */
    public String get(String key) {
        return values.get(key);
    }

    /**
     * Создание и сборка параметров.
     *
     * @param args String[].
     * @return ArgsSearch
     */
    public static ArgsSearch of(String[] args) {
        ArgsSearch argsSearch = new ArgsSearch();
        argsSearch.parse(args);
        return argsSearch;
    }
}
