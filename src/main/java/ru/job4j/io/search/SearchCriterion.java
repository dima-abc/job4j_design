package ru.job4j.io.search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 2.2.5. Контрольные вопросы
 * 2. Поиск файлов по критерию [#783 #127249]
 * Основной класс поиска фалов по критерию.
 *
 * @author Dmitry
 * @since 07.12.2021
 */
public class SearchCriterion {
    private static final StringBuilder HELP = new StringBuilder("Help search file of criterion");
    private static final String MASK = "mask";
    private static final String NAME = "name";
    private static final String REGEX = "regex";
    private static String startDirectory;
    private static String searchPattern;
    private static String searchParam;
    private static String fileResult;

    private static void getHelp() {
        String sl = System.lineSeparator();
        HELP.append(sl);
        HELP.append("Listing param:");
        HELP.append(sl);
        HELP.append("-d=START_DIRECTORY");
        HELP.append(sl);
        HELP.append("Search term:");
        HELP.append(sl);
        HELP.append("-n=MASK_FILE('?' zero or one char, '*' zero or more char) -t=mask");
        HELP.append(sl);
        HELP.append("or");
        HELP.append(sl);
        HELP.append("-n=NAME_FILE(Full file name match) -t=name");
        HELP.append(sl);
        HELP.append("or");
        HELP.append(sl);
        HELP.append("-n=REGEX(Search for a pattern with many occurrences.) -t=regex");
        HELP.append(sl);
        HELP.append("Save result: ");
        HELP.append(sl);
        HELP.append("-o=FILE_RESULT.TXT");
        System.out.println(HELP);
    }

    /**
     * Валидация входных параметров.
     *
     * @param argsName ArgsName.
     */
    private static void validate(ArgsSearch argsName) {
        startDirectory = argsName.get("d");
        searchPattern = argsName.get("n");
        searchParam = argsName.get("t");
        fileResult = argsName.get("o");
        if (!new File(startDirectory).isDirectory()) {
            throw new IllegalArgumentException("Invalid parameter -d. Enter search location -d=START_DIRECTORY");
        }
        if (!(MASK.equals(searchParam) || NAME.equals(searchParam) || REGEX.equals(searchParam))) {
            throw new IllegalArgumentException("Invalid parameter -t. Enter search param files -t=mask or -t=name or -t=regex");
        }
        if (new File(fileResult).exists() && !new File(fileResult).exists()) {
            throw new IllegalArgumentException("Invalid parameter -o. Enter search result FILE -o=FILE.TXT");
        }
    }

    public static void main(String[] args) throws IOException {
        getHelp();
        ArgsSearch argsSearch = ArgsSearch.of(args);
        validate(argsSearch);
        DispatchPattern dispatchPattern = new DispatchPattern().init();
        CriterionVisitor criterionVisitor = new CriterionVisitor(dispatchPattern.sent(searchParam, searchPattern));
        System.out.println("+++Start search+++");
        Files.walkFileTree(Path.of(startDirectory), criterionVisitor);
        System.out.println("+++End search+++");
        OutResult outResult = new OutResult();
        outResult.saveFile(criterionVisitor.getResult(), Path.of(fileResult));
    }
}
