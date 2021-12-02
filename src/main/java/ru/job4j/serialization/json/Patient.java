package ru.job4j.serialization.json;

/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * Задание. Придумать модель, описать в JSON, создать JSON и Обратно.
 *
 * @author Dmitry
 * @since 02.12.2021
 */
public class Patient {
    private final String name;
    private final int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" + "name='" + name
                + '\'' + ", age=" + age + '}';
    }
}
