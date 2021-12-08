package ru.job4j.io.search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;

/**
 * 2.2.5. Контрольные вопросы
 * 2. Поиск файлов по критерию [#783 #127249]
 * Основной класс поиска фалов по критерию.
 *
 * @author Dmitry
 * @since 07.12.2021
 */
public class SearchCriterion {
    private final StringBuilder help = new StringBuilder();
    private static final String MASK = "mask";
    private static final String NAME = "name";
    private static final String REGEX = "regex";

    private void getHelp() {
        this.help.append("Help search file of criterion");
        this.help.append("Listing param:");
    }

    private static void validate(ArgsSearch argsName) {
        String dir = argsName.get("d");
        String searchPattern = argsName.get("n");
        String searchParam = argsName.get("t");
        String fileResult = argsName.get("o");
        if (!new File(dir).isDirectory()) {
            throw new IllegalArgumentException("Invalid parameter -d. Enter search location -d=DIRECTORY");
        }
        if (!(MASK.equals(searchParam) || NAME.equals(searchParam) || REGEX.equals(searchParam))) {
            throw new IllegalArgumentException("Invalid parameter -t. Enter search param files -t=mask or -t=name or -t=regex");
        }
     /*   if (new File(fileResult).isFile()) {
            throw new IllegalArgumentException("Invalid parameter -o. Enter search result FILE -o=FILE.TXT");
        }*/
    }

    public static void main(String[] args) throws IOException {
        ArgsSearch argsSearch = ArgsSearch.of(args);
        validate(argsSearch);
        DispatchPattern dispatchPattern = new DispatchPattern();
        Predicate<Path> predicate = dispatchPattern.searchParam(argsSearch.get("t"), argsSearch.get("n"));
        CriterionVisitor criterionVisitor = new CriterionVisitor(predicate);
        Files.walkFileTree(Path.of(argsSearch.get("d")), criterionVisitor);
        OutResult outResult = new OutResult();
        outResult.saveFile(criterionVisitor.getResult(), Path.of(argsSearch.get("o")));
    }
}
