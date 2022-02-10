package ru.job4j.ood.lsp.parking;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Интерфейс реализующий поведение модели парковки.
 *
 * @author Dmitry
 * @since 09.02.2022.
 */
public interface Parking<T extends Car> {
    String getAddress();

    int getCountTrack();

    int getCountPassengerCar();

    boolean addCar(T type);

    boolean deleteCar(T type);
}
