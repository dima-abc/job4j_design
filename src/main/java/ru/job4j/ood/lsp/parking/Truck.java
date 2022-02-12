package ru.job4j.ood.lsp.parking;

import java.util.Objects;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Модель данных грузовых машин.
 *
 * @author Dmitry
 * @since 10.02.2022.
 */
public class Truck implements Transport {
    private final String name;
    private int size = 2;

    public Truck(String name) {
        this.name = name;
    }

    public Truck(String name, int size) {
        this.name = name;
        if (size > 2) {
            this.size = size;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        return size == truck.size && Objects.equals(name, truck.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}
