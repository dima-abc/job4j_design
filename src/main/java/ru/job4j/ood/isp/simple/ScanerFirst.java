package ru.job4j.ood.isp.simple;

import ru.job4j.ood.isp.simple.OfficeEquipmentFirst;

/**
 * 2.5.4. ISP
 * 0. Принцип разделения интерфейсов [#4916]
 * Пример 1.3. Класс описывает поведение Сканера,
 * реализует интерфейс описывающий поведение оргтехники.
 * Здесь реализуются не все методы так как сканер может только сканировать,
 * необходима разделить интерфейс.
 *
 * @author Dmitry
 * @since 11.02.2022.
 */
public class ScanerFirst implements OfficeEquipmentFirst {
    @Override
    public void print(String list) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String scan(String list) {
        return "Scan text: " + list;
    }

    @Override
    public void copy(String list) {
        throw new UnsupportedOperationException();
    }
}
