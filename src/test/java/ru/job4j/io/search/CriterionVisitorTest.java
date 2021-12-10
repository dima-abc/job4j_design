package ru.job4j.io.search;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * 2.2.5. Контрольные вопросы
 * 2. Поиск файлов по критерию [#783 #127249]
 * Класс обходит файловую систему и собирает файлу по "Function<Path, Boolean>".
 * Test.
 *
 * @author Dmitry.
 * @since 09.12.2021.
 */
public class CriterionVisitorTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void createFileSearch() throws IOException {
        folder.newFile("first.txt");
        folder.newFile("second.txt");
        folder.newFile("third.txt");
    }

    @Test
    public void whenSearchCriterianVisitorFileFirstTxtThenTrue() throws IOException {
        Function<Path, Boolean> predict = p -> p.getFileName().toString().equals("first.txt");
        CriterionVisitor criterionVisitor = new CriterionVisitor(predict);
        Path start = Path.of(folder.getRoot().getAbsolutePath());
        Files.walkFileTree(start, criterionVisitor);
        List<Path> list = criterionVisitor.getResult();
        assertThat(list.get(0).getFileName().toString(), is("first.txt"));
    }

    @Test
    public void whenSearchAllFilesTxtThenTrue() throws IOException {
        Function<Path, Boolean> predict = p -> p.getFileName().toString().endsWith("txt");
        CriterionVisitor criterionVisitor = new CriterionVisitor(predict);
        Path start = Path.of(folder.getRoot().getAbsolutePath());
        Files.walkFileTree(start, criterionVisitor);
        List<Path> list = criterionVisitor.getResult();
        List<String> listString = new ArrayList<>();
        list.forEach(p -> listString.add(p.getFileName().toString()));
        assertTrue(listString.contains("first.txt"));
        assertTrue(listString.contains("third.txt"));
        assertTrue(listString.contains("second.txt"));
    }
}