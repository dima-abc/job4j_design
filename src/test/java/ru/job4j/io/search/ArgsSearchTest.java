package ru.job4j.io.search;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 2.2.5. Контрольные вопросы
 * 2. Поиск файлов по критерию [#783 #127249]
 * Сбор и обработка параметров запуска.
 * Test.
 *
 * @author Dmitry
 * @since 09.12.2021.
 */
public class ArgsSearchTest {
    @Test
    public void whenGetParamThenTrue() {
        String[] args = new String[]{
                "-d=directory",
                "-n=txt",
                "-t=name",
                "-o=log.txt"
        };
        ArgsSearch argsSearch = ArgsSearch.of(args);
        assertThat(argsSearch.get("d"), is("directory"));
        assertThat(argsSearch.get("n"), is("txt"));
        assertThat(argsSearch.get("o"), is("log.txt"));
        assertThat(argsSearch.get("t"), is("name"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughParametersThenExcaption() {
        String[] args = new String[]{
                "-d=directory"
        };
        ArgsSearch argsSearch = ArgsSearch.of(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParameterIsSetIncorrectlyThenException() {
        String[] args = new String[]{
                "-d=directory",
                "-o=",
                "-t=mask",
                "-n=txt"
        };
        ArgsSearch argsSearch = ArgsSearch.of(args);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenParameterWasNotFoundThenException() {
        String[] args = new String[]{
                "-d=directory",
                "-n=txt",
                "-t=name",
                "-o=log.txt"
        };
        ArgsSearch argsSearch = ArgsSearch.of(args);
        argsSearch.get("e");
    }
}