package ru.job4j.serialization.json;

import org.json.JSONPropertyIgnore;

/**
 * 2.2.4. Сериализация
 * 5. Преобразование JSON в POJO. JsonObject [#315064]
 * Пример рекурсивного зацикливания.
 *
 * @author Dmitry
 * @since 06.11.2021
 */
public class A {
    private B b;

    @JSONPropertyIgnore
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String getHello() {
        return "Hello";
    }
}
