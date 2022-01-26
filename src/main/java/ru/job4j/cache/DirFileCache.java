package ru.job4j.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 * Класс считывает текстовый файл из фс, если файл еще не загружен.
 *
 * @author Dima_Nout
 * @since 24.01.2022.
 */
public class DirFileCache extends AbstractCache<String, String> {
    private static final Logger LOG = LoggerFactory.getLogger(DirFileCache.class.getName());
    private final String cachingDir;

    /**
     * Конструктор принимает путь рабочей директории.
     *
     * @param cachingDir isDirectory.
     */
    public DirFileCache(String cachingDir) {
        this.cachingDir = Path.of(cachingDir).normalize().toAbsolutePath().toString();
    }

    /**
     * Возвращает значение по имени файла (по ключу)
     *
     * @param key File name.
     * @return String.
     */
    @Override
    protected String load(String key) {
        Path fileName = Path.of(key);
        String result = super.get(key);
        if (result == null) {
            result = getFile(key);
            super.put(key, result);
        }
        return result;
    }

    /**
     * Загрузка файла из файловой системы.
     *
     * @param key File name.
     * @return String.
     */
    private String getFile(String key) {
        StringBuilder result = new StringBuilder();
        Path fileAbsolut = Path.of(cachingDir).resolve(key);
        try (BufferedReader in = new BufferedReader(
                new FileReader(fileAbsolut.toFile(), StandardCharsets.UTF_8))) {
            in.lines().forEach(result::append);
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
        return result.toString();
    }
}
