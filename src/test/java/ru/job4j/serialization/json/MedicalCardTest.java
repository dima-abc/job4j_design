package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * Test. Придумать модель, описать в JSON, создать JSON и Обратно.
 * 4. JAXB. Преобразование XML в POJO. [#315063]
 * Test. Сериализовать / десериализовать сущности с помощью JAXB
 * Test.5. Преобразование JSON в POJO. JsonObject [#315064]
 *
 * @author Dmitry
 * @since 06.12.2021
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

    @Test
    public void whenMedicalCardToJSONObjectThenTrue() {
        MedicalCard medicalCard = new MedicalCard(
                new Patient("Valentin", 42),
                true, 70,
                new String[]{"Inhalation", "Dropper", "Flushing"},
                'a');
        JSONObject jsonObject = new JSONObject(medicalCard);
        JSONObject patientJson = (JSONObject) jsonObject.get("patient");
        assertThat(medicalCard.getPatient().getName(), is(patientJson.getString("name")));
        assertThat(medicalCard.getPatient().getAge(), is(patientJson.getInt("age")));
        assertThat(medicalCard.getSmoking(), is(jsonObject.getBoolean("smoking")));
        assertThat(medicalCard.getWeight(), is(jsonObject.getInt("weight")));
        JSONArray medProcJSONArray = (JSONArray) jsonObject.get("medProc");
        assertThat(medicalCard.getMedProc()[0], is(medProcJSONArray.getString(0)));
        assertThat(medicalCard.getMedProc()[1], is(medProcJSONArray.getString(1)));
        assertThat(medicalCard.getMedProc()[2], is(medProcJSONArray.getString(2)));
        assertThat(medicalCard.getGroup(), is(jsonObject.get("group")));
    }

    @Test
    public void whenJSONObjectOfXmlThenEqualsJSONObjectOftMedicalCard() {
        MedicalCard medicalCard = new MedicalCard(
                new Patient("Valentin", 42),
                true, 70,
                new String[]{"Inhalation", "Dropper", "Flushing"},
                'a');
        String xml =
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
        JSONObject jsonObjectOfObject = new JSONObject(medicalCard);
        JSONObject jsonObjectOfXml = new JSONObject(xml);
        assertEquals(jsonObjectOfObject.toString(), jsonObjectOfXml.toString());
    }
}