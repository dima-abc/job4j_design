package ru.job4j.ood.isp;

/**
 * 2.5.4. ISP
 * 0. Принцип разделения интерфейсов [#4916]
 * Пример 1.2. Класс описывает поведение Принтера,
 * реализует интерфейс описывающий поведение оргтехники.
 * Здесь реализуются не все методы так как принтер может только печатать,
 * необходима разделить интерфейс.
 *
 * @author Dmitry
 * @since 11.02.2022.
 */
public class PrinterFirst implements OfficeEquipmentFirst {
    @Override
    public void print(String list) {
        System.out.println("Print text: " + list);
    }

    @Override
    public String scan(String list) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void copy(String list) {
        throw new UnsupportedOperationException();
    }
}
