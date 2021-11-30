package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2.2.3. Логирование.
 * 1. Log4j. Логирование системы.[#95335#127253].
 * 2. Simple Loggin Facade 4 Java. [#268849 #127252]
 * 3. Slf4j - вывод переменных.
 *
 * @author Dmitry
 * @since 30.11.2021
 */
public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        byte first = 8;
        short second = 16;
        int third = 32;
        long fourth = 64;
        float fifth = 32.32F;
        double sixth = 64.64D;
        char seventh = 'c';
        boolean eighth = true;
        LOG.debug(
                "User info byte first : {}, short second : {}, int third : {}, long fourth : {}",
                first, second, third, fourth);
        LOG.debug(
                "User info byte float fifth : {}, double sixth : {}, char seventh : {}, boolean eighth : {}",
                fifth, sixth, seventh, eighth);

    }
}
