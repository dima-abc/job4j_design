package ru.job4j.serialization.java;

import java.io.*;
import java.nio.file.Files;

/**
 * 2.2.4. Сериализация
 * 1. Что такое Сериализация?[#313163]
 *
 * @author Dmitry.
 * @since 30.11.2021.
 */
public class Contact implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" + "zipCode=" + zipCode
                + ", phone='" + phone + '\'' + '}';
    }

    /**
     * Метод сериализует объект Contact в файл.
     *
     * @param serialFile File
     * @param contact    Contact
     */
    public void serial(File serialFile, Contact contact) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(serialFile))) {
            oos.writeObject(contact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод десериализует обьект Contact из файла
     *
     * @param serialFile File
     * @return Contact.
     */
    public Contact deSerial(File serialFile) {
        Contact result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serialFile))) {
            result = (Contact) ois.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return result;
    }
}
