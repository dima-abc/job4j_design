package ru.job4j.io.search;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2.2.5. Контрольные вопросы
 * 2. Поиск файлов по критерию [#783 #127249]
 * Схема отправки для получения условий поиска файла.
 *
 * @author Dmitry
 * @since 09.12.2021
 */

public class DispatchPattern {
    private final String mask = "mask";
    private final String name = "name";
    private final String regex = "regex";
    private final Map<String, BiFunction<Path, String, Boolean>> mapDispatch = new HashMap<>();

    /**
     * Поиск по маске.
     * '*' - любое количество символов.
     * '?' - один символ.
     *
     * @return Boolean.
     */
    private BiFunction<Path, String, Boolean> toMask() {
        return (p, s) -> {
            s = s.replaceAll("[*]", ".*");
            s = s.replaceAll("[?]", ".?");
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(p.getFileName().toString());
            return matcher.matches();
        };
    }

    /**
     * Поиск по имени фала. Строгое совпадение.
     *
     * @return Boolean.
     */
    private BiFunction<Path, String, Boolean> toName() {
        return (p, s) -> s.equals(p.getFileName().toString());
    }

    /**
     * Поиск файла по регулярному выражению.
     * Предполагается что изначально указывается регульрное выражение.
     * Так же учитывается множество вхождений/совпадений.
     *
     * @return Boolean.
     */
    private BiFunction<Path, String, Boolean> toRegex() {
        return (p, s) -> {
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(p.getFileName().toString());
            return matcher.find();
        };
    }

    /**
     * Инициализация отправки.
     *
     * @return DispatchPattern.
     */
    public DispatchPattern init() {
        this.load(this.mask, toMask());
        this.load(this.name, toName());
        this.load(this.regex, toRegex());
        return this;
    }

    /**
     * Добавление функции в MAP.
     *
     * @param key    String key.
     * @param handle BiFunction.
     */
    private void load(String key, BiFunction<Path, String, Boolean> handle) {
        this.mapDispatch.put(key, handle);
    }

    /**
     * Возвращает параметры поиска в виде функционального интерфейса.
     *
     * @param key   Key.
     * @param param Pattern.
     * @return Function(Path).
     */
    public Function<Path, Boolean> sent(final String key, String param) {
        return p -> this.mapDispatch.get(key).apply(p, param);
    }
}
