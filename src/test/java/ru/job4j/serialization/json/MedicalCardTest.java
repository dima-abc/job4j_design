package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * Test. Придумать модель, описать в JSON, создать JSON и Обратно.
 * 4. JAXB. Преобразование XML в POJO. [#315063]
 * Test. Сериализовать / десериализовать сущности с помощью JAXB
 *
 * @author Dmitry
 * @since 02.12.2021
 */
public class MedicalCardTest {
    @Test
    public void whenJaxbMedicalCartMarshallerAndUnMarshallerThenEqualsTrue() throws JAXBException, IOException {
        MedicalCard medicalCard = new MedicalCard(
                new Patient("Valentin", 42),
                true, 70,
                new String[]{"Inhalation", "Dropper", "Flushing"},
                'a');
        String xml = MedicalCard.marshallerMedicalCard(medicalCard);
        MedicalCard medicalCardUnMarshaller = MedicalCard.unMarshallerMedicalCard(xml);
        assertEquals(medicalCard.toString(), medicalCardUnMarshaller.toString());
    }

    @Test
    public void whenMedicalCordToJasonAndJsonToMedicalCardThenTrue() {
        final MedicalCard medicalCard = new MedicalCard(
                new Patient("Valentin", 42),
                true, 70,
                new String[]{"Inhalation", "Dropper", "Flushing"},
                'a');
        final Gson gson = new GsonBuilder().create();
        String medicalCardJson = gson.toJson(medicalCard);
        String medicalToJsonString =
                "{"
                        + "\"patient\":"
                        + "{"
                        + "\"name\":\"Valentin\",\"age\":42"
                        + "},"
                        + "\"smoking\":true,"
                        + "\"weight\":70,"
                        + "\"medProc\":[\"Inhalation\",\"Dropper\",\"Flushing\"],"
                        + "\"group\":\"a\""
                        + "}";
        assertEquals(medicalCardJson, medicalToJsonString);
        final MedicalCard jsonToMedicalCard = gson.fromJson(medicalToJsonString, MedicalCard.class);
        assertEquals(medicalCard.toString(), jsonToMedicalCard.toString());
    }
}