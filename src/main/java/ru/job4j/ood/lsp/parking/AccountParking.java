package ru.job4j.ood.lsp.parking;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Класс определяет распределение машин на парковку.
 *
 * @author Dmitry
 * @since 10.02.2022.
 */
public class AccountParking implements Account<Car> {
    public AccountParking(Parking<Car> parking) {
    }

    @Override
    public boolean enterCar(Car car) {
        return false;
    }

    @Override
    public boolean exitCar(Car car) {
        return false;
    }
}
