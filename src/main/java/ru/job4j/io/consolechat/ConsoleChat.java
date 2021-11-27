package ru.job4j.io.consolechat;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
            String muwBot = "";
            List<String> botPhrase = readPhrases();
            System.out.printf("Команды для чата %s, %s, %s %n", STOP, CONTINUE, OUT);
            System.out.println("Введите текст для общения в чате");
            do {
                System.out.print("-->");
                wordUser = in.readLine();
                this.logChat.add("User: ".concat(wordUser));
                wordUser = wordUser.toLowerCase();
                if (wordUser.equals(STOP)) {
                    muwBot = STOP;
                    continue;
                }
                if (wordUser.equals(CONTINUE)) {
                    muwBot = CONTINUE;
                }
                if (!muwBot.equals(STOP) && !wordUser.equals(OUT)) {
                    wordBot = generatePhrases(botPhrase);
                    this.logChat.add("Bot: ".concat(wordBot));
                    System.out.printf("Bot: %s%n", wordBot);
                }
            } while (!wordUser.equals(OUT));
            saveLog(this.logChat);
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
                (new FileReader(this.botAnswers, StandardCharsets.UTF_8)))) {
            inFile.lines().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Генерация случайно фразы.
     *
     * @param phrases List
     * @return String
     */
    private String generatePhrases(List<String> phrases) {
        int rnd = (int) (Math.random() * phrases.size());
        return phrases.get(rnd);
    }

    /**
     * Сохраняет лог чата в файл.
     *
     * @param logChat List.
     */
    private void saveLog(List<String> logChat) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(this.logPath, StandardCharsets.UTF_8, true))) {
            for (String log : this.logChat) {
                out.printf("%s%n", log);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        ConsoleChat consoleChat = new ConsoleChat(argsName.get("log"), argsName.get("phrase"));
        consoleChat.run();
    }
}
