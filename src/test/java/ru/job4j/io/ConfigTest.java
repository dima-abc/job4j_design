package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.2.1. Ввод-вывод.
 * 1. Читаем файл конфигурации [#858 #127260].
 * Test.
 *
 * @author Dmitry
 * @version 1
 * @since 15.11.2021
 */
public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/config/pair_without_comment.properties";
        Config config = Config.of(path);
        assertThat(config.get("name"), is("Petr Arsentev"));
        assertThat(config.get("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithSpaces() {
        String path = "./data/config/pair_with_spaces.properties";
        Config config = Config.of(path);
        assertThat(config.get("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.get("hibernate.connection.password"), is("password"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/config/pair_with_comment.properties";
        Config config = Config.of(path);
        assertThat(config.get("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.get("hibernate.connection.password"), is("password"));
        assertThat(config.get("# Login"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithCommentAndSpaces() {
        String path = "./data/config/pair_with_comment_and_spaces.properties";
        Config config = Config.of(path);
        assertThat(config.get("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.get("hibernate.connection.password"), is("password"));
        assertThat(config.get("# Login"), is(Matchers.nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithIllegalArgumentThenException() {
        String path = "./data/config/pair_with_exception.properties";
        Config config = Config.of(path);
    }
}