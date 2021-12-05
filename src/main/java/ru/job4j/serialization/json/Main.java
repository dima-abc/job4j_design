package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * Создание Json
 * 4. JAXB. Преобразование XML в POJO. [#315063]
 * Сериализовать / десериализовать сущности с помощью JAXB
 *
 * @author Dmitry
 * @since 05.12.2021
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person(false, 30, new Contact("11-111"),
                new String[]{"Worker", "Married"});
        Gson gson = new GsonBuilder().create();
        String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"concat\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        Person personMod = gson.fromJson(personJson, Person.class);
    }

    public static String marshallerPerson(Person person) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String resultXML;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            resultXML = writer.getBuffer().toString();
        }
        return resultXML;
    }

    public static Person unmarshallerPerson(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Person result;
        try (StringReader reader = new StringReader(xml)) {
            result = (Person) unmarshaller.unmarshal(reader);
        }
        return result;
    }
}
