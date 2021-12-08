package ru.job4j.io.search;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DispatchPattern {
    private final String mask = "mask";
    private final String name = "name";
    private final String regex = "regex";
    private final Map<String, BiFunction<Path, String, Boolean>> mapDispatch = new HashMap<>();

    public Predicate<Path> searchParam(String param, String searchPattern) {
        Predicate<Path> result = null;
        if (mask.equals(param)) {
            String string = searchPattern.replaceFirst("[*.]", ".*");
            return p -> {
                Pattern pattern = Pattern.compile(string);
                Matcher matcher = pattern.matcher(p.getFileName().toString());
                return matcher.matches();
            };
        }
        if (name.equals(param)) {
            return p -> searchPattern.equals(p.getFileName().toString());
        }
        if (regex.equals(param)) {
            return p -> {
                Pattern pattern = Pattern.compile(searchPattern);
                Matcher matcher = pattern.matcher(p.getFileName().toString());
                return matcher.find();
            };
        }
        return result;
    }
}
