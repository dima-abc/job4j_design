package ru.job4j.ood.lsp.parking;
/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Модель данных легковых машин.
 *
 * @author Dmitry
 * @since 10.02.2022.
 */
public class PassengerCar implements Car {

    public PassengerCar(String name, int size) {
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
