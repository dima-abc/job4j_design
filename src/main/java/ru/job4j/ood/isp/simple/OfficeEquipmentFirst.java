package ru.job4j.ood.isp.simple;

/**
 * 2.5.4. ISP
 * 0. Принцип разделения интерфейсов [#4916]
 * пример 1. Интерфейс описывает поведение Оргтехники.
 *
 * @author Dmitry
 * @since 11.02.2022.
 */
public interface OfficeEquipmentFirst {
    void print(String list);
    String scan(String list);
    void copy(String list);
}
