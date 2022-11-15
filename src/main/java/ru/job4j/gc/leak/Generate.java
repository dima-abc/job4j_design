package ru.job4j.gc.leak;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2. Джуниор
 * 2.4. Garbage Collection
 * 2.4.3. Профилирование приложения
 * 2. Найти утечку памяти. [#504882]
 * Интерфейс генератора
 * (чтение не будем реализовывать отдельно для экономии кода в задании,
 * поэтому реализуем как дефолтный метод в Generate)
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.11.2022
 */
public interface Generate {

    void generate();

    default List<String> read(String path) throws IOException {
        return Files.lines(Paths.get(path))
                .collect(Collectors.toList());
    }
}
