package ru.job4j.serialization.java;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * 2.2.4. Сериализация
 * 1. Что такое Сериализация?[#313163]
 *
 * @author Dmitry.
 * @since 30.11.2021.
 */
public class ContactTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void whenSerializedContactToFileAndDeserializedToFileToContactTwoThenEqualsTrue() throws IOException {
        File file = temporaryFolder.newFile("contactFile.txt");
        final Contact contactFirst = new Contact(12345678, "+7(111) 111-11-11");
        contactFirst.serial(file, contactFirst);
        final Contact contactSecond = contactFirst.deSerial(file);
        assertEquals(contactFirst.getZipCode(), contactSecond.getZipCode());
        assertEquals(contactFirst.getPhone(), contactSecond.getPhone());
        assertEquals(contactFirst.toString(), contactSecond.toString());
    }
}