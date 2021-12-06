package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * Задание. Придумать модель, описать в JSON, создать JSON и Обратно.
 * 4. JAXB. Преобразование XML в POJO. [#315063]
 * Сериализовать / десериализовать сущности с помощью JAXB
 * 5. Преобразование JSON в POJO. JsonObject [#315064]
 *
 * @author Dmitry
 * @since 06.12.2021
 */
@XmlRootElement(name = "patient")
public class Patient {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int age;

    public Patient() {
    }

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Patient{" + "name='" + name
                + '\'' + ", age=" + age + '}';
    }
}
