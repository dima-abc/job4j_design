package ru.job4j.io.search;

import org.junit.Test;

import java.nio.file.Path;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * 2.2.5. Контрольные вопросы
 * 2. Поиск файлов по критерию [#783 #127249]
 * Схема отправки для получения условий поиска файла.
 * Test.
 *
 * @author Dmitry
 * @since 09.12.2021/
 */
public class DispatchPatternTest {
    @Test
    public void whenGetKeyNameEqualsFileThenTrue() {
        DispatchPattern dispatchPattern = new DispatchPattern().init();
        Function<Path, Boolean> predict = dispatchPattern.sent("name", "file.txt");
        assertTrue(predict.apply(Path.of("file.txt")));
    }

    @Test
    public void whenGetKeyNameEqualsFileThenFalse() {
        DispatchPattern dispatchPattern = new DispatchPattern().init();
        Function<Path, Boolean> predict = dispatchPattern.sent("name", "file.txt");
        assertFalse(predict.apply(Path.of("name.txt")));
    }

    @Test
    public void whenGetKeyMaskAppleMaskMoreCharThenTrue() {
        DispatchPattern dispatchPattern = new DispatchPattern().init();
        Function<Path, Boolean> predict = dispatchPattern.sent("mask", "*.txt");
        assertTrue(predict.apply(Path.of("file.txt")));
        assertTrue(predict.apply(Path.of("name.txt")));
    }

    @Test
    public void whenGetKeyMaskAppleMaskOneCharThenTrue() {
        DispatchPattern dispatchPattern = new DispatchPattern().init();
        Function<Path, Boolean> predict = dispatchPattern.sent("mask", "?ile.txt");
        assertTrue(predict.apply(Path.of("file.txt")));
        assertTrue(predict.apply(Path.of("pile.txt")));
        assertFalse(predict.apply(Path.of("ffile.txt")));
    }

    @Test
    public void whenGetKeyRegexAppleThenTrue() {
        DispatchPattern dispatchPattern = new DispatchPattern().init();
        Function<Path, Boolean> predict = dispatchPattern.sent("regex", "[il].*");
        assertTrue(predict.apply(Path.of("file.txt")));
        assertTrue(predict.apply(Path.of("pile.txt")));
        assertFalse(predict.apply(Path.of("name.txt")));
    }

}