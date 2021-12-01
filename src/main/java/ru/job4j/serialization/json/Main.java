package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * Создание Json
 *
 * @author Dmitry
 * @since 01.12.2021
 */
public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"),
                new String[]{"Worker", "Married"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(person);
        System.out.println(gson.toJson(person));
        final String personJson =
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
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
        System.out.println(personJson);
    }
}
