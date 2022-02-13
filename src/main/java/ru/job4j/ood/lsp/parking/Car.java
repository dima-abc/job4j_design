package ru.job4j.ood.lsp.parking;

import java.util.Objects;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Модель данных легковых машин.
 *
 * @author Dmitry
 * @since 10.02.2022.
 */
public class Car implements Transport {
    private final String name;
    public static final int SIZE = 1;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
