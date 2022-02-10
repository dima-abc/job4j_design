package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Test. Модель данных грузовых машин.
 *
 * @author Dmitry
 * @since 10.02.2022.
 */
public class PassengerCarTest {

    @Ignore
    @Test
    public void whenGetNamePassengerCarThenUAZ() {
        Car track = new Track("UAZ", 1);
        assertThat(track.getName(), is("UAZ"));
    }

    @Ignore
    @Test
    public void whenGetSizePassengerCarThen1() {
        Car track = new Track("UAZ", 1);
        assertThat(track.getSize(), is(1));
    }

}