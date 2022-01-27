package ru.job4j.cache;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.4.4. Типы ссылок и коллекции на soft weak ссылках.
 * 1. Реализация кеша на SoftReference [#1592].
 * Test.
 *
 * @since 26.01.2022
 */
public class DirFileCacheTest {

    @Test
    public void whenLoadDirFileToCache() {
        String dir = "./data";
        String file = "cacheTest.txt";
        AbstractCache<String, String> dirFileCache = new DirFileCache(dir);
        String result = dirFileCache.load(file);
        String expected = "cache:\r\ncache:\r\ncache";
        assertThat(result, is(expected));
    }

    @Test
    public void whenAbstractCacheGetFileOnCache() {
        String dir = "./data";
        String file = "cacheTest.txt";
        AbstractCache<String, String> dirFileCache = new DirFileCache(dir);
        String result = dirFileCache.load(file);
        String expected = dirFileCache.get(file);
        assertThat(result, is(expected));
    }

    @Test
    public void whenAbstractCatchPut() {
        String dir = "./data";
        AbstractCache<String, String> cache = new DirFileCache(dir);
        cache.put("1", "one");
        assertThat(cache.get("1"), is("one"));
    }

}