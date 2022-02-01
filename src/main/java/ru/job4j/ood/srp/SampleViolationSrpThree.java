package ru.job4j.ood.srp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * 2.5.1. SRP
 * 0. Принцип единственной ответственности [#4913]
 * Пример 3. Клас преобразует дату в определенный формат, при этом сам форматер создается внутри.
 * Необходима получать форматер в конструкторе.
 *
 * @author Dima_Nout
 * @since 01.02.2022
 */
public class SampleViolationSrpThree {
    public String getDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        return dateTimeFormatter.format(localDateTime);
    }
}
