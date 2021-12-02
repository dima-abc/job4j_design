package ru.job4j.serialization.json;

import java.util.Arrays;
import javax.xml.bind.annotation.*;


/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * 4. JAXB. Преобразование XML в POJO. [#315063]
 * Модель данных Person.
 *
 * @author Dmitry
 * @since 02.12.2021
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlAttribute
    private boolean sex;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private Contact contact;
    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "statuses")
    private String[] statuses;

    public Person() {
    }

    public Person(boolean sex, int age, Contact contact, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{" + "sex=" + sex + ", age="
                + age + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses) + '}';
    }
}
