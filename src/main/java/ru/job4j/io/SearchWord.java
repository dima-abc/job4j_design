package ru.job4j.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * 3. Мидл
 * 3.5. МикросервисыТема
 * 3.5.4. Docker
 * 2. Управление образами [#504778]
 * 1. На основе образа OpenJDK собрать образ с программой:
 * 1.1. Программа должно посчитать количество вхождений слова в текстовом файле
 * 1.2. Файл с программой и со словами предварительно перенести в контейнер
 * 1.3. Слово в качестве аргумента должно браться из аргументов командной строки
 * 1.4. Программа должно запускаться через команду docker run
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 26.05.2023
 */
public class SearchWord {
    public static final String WORD = "word_list.txt";

    /**
     * Название файла со словами word_list.txt
     * args[0] искомое слово в фале
     * Вывод количество раз сколько встречается слово
     *
     * @param args param cmd
     */
    public static void main(String[] args) {
        var wordSearch = args[0];
        long countWordEnter = 0;
        Path path = Path.of(WORD);
        try {
            var wordList = Files.lines(path, StandardCharsets.UTF_8);
            countWordEnter = wordList.flatMap((l) -> Arrays.stream(l.split("\\s")))
                    .filter(wordSearch::contains)
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = String.format(
                "The number: %d ,of occurrences of words: %s ,in a text file: %s",
                countWordEnter, wordSearch, path);
        System.out.println(result);
    }
}
