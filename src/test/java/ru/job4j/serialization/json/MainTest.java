package ru.job4j.serialization.json;

import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * 2.2.4. Сериализация
 * 4. JAXB. Преобразование XML в POJO. [#315063]
 * Сериализовать / десериализовать сущности с помощью JAXB
 *
 * @author Dima_Nout
 * @since 5.12.2021
 */
public class MainTest {
    @Test
    public void whenJaxbPersonAndContextMarshallerAndUnMarshallerThenEqualsTrue() throws JAXBException, IOException {
        Person person = new Person(false, 30, new Contact("111-1111"),
                new String[]{"Worker", "Married"});
        String xml = Main.marshallerPerson(person);
        Person unMarshallerPerson = Main.unmarshallerPerson(xml);
        System.out.println(person);
        System.out.println(unMarshallerPerson);
        System.out.println(xml);
        assertEquals(person.toString(), unMarshallerPerson.toString());
    }

}