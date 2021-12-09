package ru.job4j.io.search;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.2.5. Контрольные вопросы.
 * 2. Поиск файлов по критерию [#783 #127249].
 * Сохранение результата в файл.
 * Test.
 *
 * @author Dmitry.
 * @since 09.12.2021.
 */
public class OutResultTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenSaveListPathOfFileThenTrue() throws IOException {
        File logFile = folder.newFile("log.txt");
        List<Path> pathList = List.of(Path.of("first.txt"), Path.of("second.txt"));
        OutResult outResult = new OutResult();
        outResult.saveFile(pathList, logFile.toPath());
        StringJoiner rsl = new StringJoiner(" ");
        try (BufferedReader in = new BufferedReader(new FileReader(logFile))) {
            in.lines().forEach(f -> rsl.add(Paths.get(f).getFileName().toString()));
        }
        assertThat(rsl.toString(), is("first.txt second.txt"));
    }
}