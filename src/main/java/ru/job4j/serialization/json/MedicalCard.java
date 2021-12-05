package ru.job4j.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * Задание. Придумать модель, описать в JSON, создать JSON и Обратно.
 * 4. JAXB. Преобразование XML в POJO. [#315063]
 * Сериализовать / десериализовать сущности с помощью JAXB
 *
 * @author Dmitry
 * @since 05.12.2021
 */
@XmlRootElement(name = "medicalCard")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicalCard {
    @XmlElement
    private Patient patient;
    @XmlAttribute
    private Boolean smoking;
    @XmlAttribute
    private int weight;
    @XmlElementWrapper(name = "procedures")
    @XmlElement(name = "procedure")
    private String[] medProc;
    @XmlAttribute
    private char group;

    public MedicalCard() {
    }

    public MedicalCard(Patient patient, Boolean smoking, int weight, String[] medProc, char group) {
        this.patient = patient;
        this.smoking = smoking;
        this.weight = weight;
        this.medProc = medProc;
        this.group = group;
    }

    @Override
    public String toString() {
        return "MedicalCard{" + "patient=" + patient + ", smoking="
                + smoking + ", weight=" + weight + ", medProc="
                + Arrays.toString(medProc) + ", group=" + group + '}';
    }

    /**
     * JAXB marshaller to Xml
     *
     * @param medicalCard MedicalCard.class
     * @return XML String
     * @throws JAXBException Exception
     * @throws IOException   Exception
     */
    public static String marshallerMedicalCard(MedicalCard medicalCard) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(MedicalCard.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String resultXml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(medicalCard, writer);
            resultXml = writer.getBuffer().toString();
        }
        return resultXml;
    }

    /**
     * JAXB UnMarshaller reader XML to MedicalCard.class
     *
     * @param xml XML
     * @return MedicalCard
     * @throws JAXBException Exception
     */
    public static MedicalCard unMarshallerMedicalCard(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(MedicalCard.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        MedicalCard result;
        try (StringReader reader = new StringReader(xml)) {
            result = (MedicalCard) unmarshaller.unmarshal(reader);
        }
        return result;
    }
}
