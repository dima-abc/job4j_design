package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.0. TDD
 * 3. Шаблонизатор. [#855]
 * Test Generate.
 *
 * @author Dima_Nout
 * @since 30.01.2022
 */
public class GeneratorTest {
    @Ignore
    @Test
    public void whenGenerateSample() {
        Generator generator = new GeneratorSample();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "name",
                "subject", "subject");
        assertThat(generator.produce(template, args), is("I am a name, Who are subject?"));
    }

    @Ignore
    @Test(expected = NoSuchElementException.class)
    public void whenGenerateNotKeySample() {
        Generator generator = new GeneratorSample();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        generator.produce(template, args);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenGenerateExtraKey() {
        Generator generator = new GeneratorSample();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "name",
                "subject", "subject",
                "ExtraKye", "ExtraKey");
        generator.produce(template, args);
    }
}