package ru.job4j.ood.lsp.parking;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Класс определяет распределение машин на парковку.
 *
 * @author Dmitry
 * @since 10.02.2022.
 */
public class Parking implements Camp<Transport> {
    private final Transport[] trucks;
    private final Transport[] cars;

    public Parking(int sizeTruckParking, int sizeCarParking) {
        this.trucks = new Transport[sizeTruckParking];
        this.cars = new Transport[sizeCarParking];
    }

    /**
     * Метод распределяет автомобили на парковки.
     *
     * @param transport Transport
     * @return boolean.
     */
    @Override
    public boolean enterTransport(Transport transport) {
        boolean result = false;
        if (transport.getSize() == Car.SIZE) {
            result = addCar(transport);
        } else if (transport.getSize() > Car.SIZE) {
            result = addTruck(transport);
        }
        return result;
    }

    /**
     * Поставить легковой автомобиль на парковку для легковых.
     *
     * @param car Transport.
     * @return boolean.
     */
    private boolean addCar(Transport car) {
        boolean result = false;
        int pointCarParking = findPointTransport(cars, Car.SIZE);
        if (pointCarParking > -1) {
            cars[pointCarParking] = car;
            result = true;
        }
        return result;
    }

    /**
     * Метод ставит грузовик на парковку.
     *
     * @param track Transport.
     * @return boolean.
     */
    private boolean addTruck(Transport track) {
        boolean result = false;
        int pointTruckParking = findPointTransport(trucks, Car.SIZE);
        if (pointTruckParking > -1) {
            trucks[pointTruckParking] = track;
            result = true;
        }
        if (!result) {
            int pointCarParking = findPointTransport(cars, track.getSize());
            result = addTrackInPassenger(track, pointCarParking);
        }
        return result;
    }

    /**
     * Метод ставить грузовик на парковку для легковых.
     *
     * @param truck Transport.
     * @return boolean.
     */
    private boolean addTrackInPassenger(Transport truck, int pointCarParking) {
        boolean result = false;
        if (pointCarParking > -1) {
            for (int i = pointCarParking - truck.getSize() + 1; i <= pointCarParking; i++) {
                cars[i] = truck;
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод ищет свободное места для грузовика на пассажирской парковке.
     *
     * @param transports    Transport
     * @param sizeTransport int
     * @return int
     */
    private int findPointTransport(Transport[] transports, int sizeTransport) {
        int result = -1;
        int step = 0;
        for (int i = 0; i < transports.length; i++) {
            if (transports[i] == null) {
                step++;
            }
            if (transports[i] != null) {
                step = 0;
            }
            if (step == sizeTransport) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * Метод осуществляет выезд с парковки указанного вида транспорта.
     *
     * @param transport Transport.
     * @return boolean.
     */
    @Override
    public boolean exitTransport(Transport transport) {
        boolean result = false;
        if (transport.getSize() >= Car.SIZE) {
            result = exitParking(cars, transport);
        }
        if (transport.getSize() > Car.SIZE && !result) {
            result = exitParking(trucks, transport);
        }
        return result;
    }

    /**
     * Удаляет транспорт с парковки.
     *
     * @param transports Transport[].
     * @param transport  Transport
     * @return boolean.
     */
    private boolean exitParking(Transport[] transports, Transport transport) {
        boolean result = false;
        for (int i = 0; i < transports.length; i++) {
            if (transport.equals(transports[i])) {
                transports[i] = null;
                result = true;
            }
        }
        return result;
    }
}
