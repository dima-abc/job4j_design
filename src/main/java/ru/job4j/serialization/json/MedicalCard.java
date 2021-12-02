package ru.job4j.serialization.json;

import java.util.Arrays;

/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * Задание. Придумать модель, описать в JSON, создать JSON и Обратно.
 *
 * @author Dmitry
 * @since 02.12.2021
 */
public class MedicalCard {
    private final Patient patient;
    private final Boolean smoking;
    private final int weight;
    private final String[] medProc;
    private final char group;

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
}
