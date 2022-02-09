package ru.job4j.ood.lsp.parking;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Интерфейс реализующий поведение учета парковочных мест.
 *
 * @author Dmitry
 * @since 09.02.2022.
 */
public interface Account<Parking, Car> {
    Car enterCar(Car car, Parking parking);

    Car exitCar(Car car, Parking parking);
}
