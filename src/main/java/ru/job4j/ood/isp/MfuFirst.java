package ru.job4j.ood.isp;

/**
 * 2.5.4. ISP
 * 0. Принцип разделения интерфейсов [#4916]
 * Пример 1.1. Класс описывает поведение МФУ,
 * реализует интерфейс описывающий поведение оргтехники.
 * Здесь все хорошо все методы реализованы.
 *
 * @author Dmitry
 * @since 11.02.2022.
 */
public class MfuFirst implements OfficeEquipmentFirst {
    @Override
    public void print(String list) {
        System.out.println("Print text: " + list);
    }

    @Override
    public String scan(String list) {
        return "Scan text: " + list;
    }

    @Override
    public void copy(String list) {
        print(scan(list));
    }
}
