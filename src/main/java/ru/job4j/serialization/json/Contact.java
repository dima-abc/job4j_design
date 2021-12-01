package ru.job4j.serialization.json;

/**
 * 2.2.4. Сериализация
 * 2. Формат JSON [#313164]
 * Модель данных Contact.
 *
 * @author Dmitry
 * @since 01.12.2021
 */
public class Contact {
    private final String phone;

    public Contact(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" + "phone='"
                + phone + '\'' + '}';
    }
}
