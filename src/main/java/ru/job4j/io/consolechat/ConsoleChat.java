package ru.job4j.io.consolechat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 2.2.1. Ввод-вывод
 * 6. Кодировка. [#862 #127257]
 * Задание консольный чат.
 *
 * @author Dmitry
 * @version 1
 * @since 26.11.2021
 */
public class ConsoleChat {
    private final String logPath;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> logChat = new ArrayList<>();

    public ConsoleChat(String logPath, String botAnswers) {
        this.logPath = logPath;
        this.botAnswers = botAnswers;
    }

    /**
     * Метод содержит логики чата.
     */
    public void run() {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in))) {
            String wordUser;
            String wordBot;
            System.out.printf("Команды для чата %s, %s, %s %n", STOP, CONTINUE, OUT);
            System.out.println("Введите текст для общения в чате");
            do {
                wordUser = in.readLine();

            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Чтение фразы из файла.
     *
     * @return List.
     */
    private List<String> readPhrases() {
        List<String> result = new ArrayList<>();
        try (BufferedReader inFile = new BufferedReader(
                (new FileReader(this.botAnswers)))) {
            inFile.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Сохраняет лог чата в файл.
     *
     * @param log List.
     */
    private void saveLog(List<String> log) {

    }

    public static void main(String[] args) {

    }
}
