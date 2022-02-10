package ru.job4j.ood.lsp.parking;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Класс описывающий хранилище парковки.
 *
 * @author Dmitry
 * @since 10.02.2022.
 */
public class ParkingCar implements Parking<Car> {

    public ParkingCar(String address, int countTrack, int countPassengerCar) {
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public int getCountTrack() {
        return 0;
    }

    @Override
    public int getCountPassengerCar() {
        return 0;
    }

    @Override
    public boolean addCar(Car type) {
        return false;
    }

    @Override
    public boolean deleteCar(Car type) {
        return false;
    }
}
