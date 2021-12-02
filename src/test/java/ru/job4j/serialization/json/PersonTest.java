package ru.job4j.serialization.json;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * 2.2.4. Сериализация
 * 4. JAXB. Преобразование XML в POJO. [#315063]
 * Тестирование сериализации и десериализации JAXB
 *
 * @author Dmitry
 * @since 02.12.2021
 */
public class PersonTest {
    @Test
    public void whenSerializationDeserializationToJaxbPersonClassThenTrue() throws Exception {
        Person person = new Person(false, 30,
                new Contact("11-111"),
                new String[]{"Worker", "Married"});
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            xml = writer.getBuffer().toString();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();

        try (StringReader reader = new StringReader(xml)) {
            Person result = (Person) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}