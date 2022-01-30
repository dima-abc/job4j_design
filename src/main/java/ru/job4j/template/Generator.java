package ru.job4j.template;

import java.util.Map;

/**
 * 2.5.0. TDD
 * 3. Шаблонизатор. [#855]
 * Interface Generate.
 *
 * @author Dima_Nout
 * @since 30.01.2022
 */
public interface Generator {
    String produce(String template, Map<String, String> args);
}
