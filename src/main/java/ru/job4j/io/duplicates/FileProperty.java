package ru.job4j.io.duplicates;

import java.util.Objects;

/**
 * 2.2.1. Ввод-вывод
 * 4.2. Поиск дубликатов [#315066]
 * Модель данных Для файла.
 *
 * @author Dima_Nout
 * @version 1
 * @since 20.11.2021
 */
public class FileProperty {
    private long size;
    private String name;

    public FileProperty(long size, String name) {
        this.size = size;
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public FileProperty setSize(long size) {
        this.size = size;
        return this;
    }

    public String getName() {
        return name;
    }

    public FileProperty setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileProperty that = (FileProperty) o;
        return size == that.size && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }
}
