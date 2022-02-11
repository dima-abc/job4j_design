package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Test. Класс определяет распределение машин на парковку.
 *
 * @author Dmitry
 * @since 10.02.2022.
 */
public class AccountParkingTest {
    @Ignore
    @Test
    public void whenEnterTrackThisPlaceAndPassengerCarThisPlaceThenTrue() {
        Account<Car> account = new AccountParking(new ParkingCar("MEGA", 2, 2));
        Car passengerCar = new PassengerCar("UAZ", 1);
        Car track = new Track("KAMAZ", 2);
        assertTrue(account.enterCar(passengerCar));
        assertTrue(account.enterCar(passengerCar));
        assertTrue(account.enterCar(track));
        assertTrue(account.enterCar(track));
    }

    @Ignore
    @Test
    public void whenEnterTrackThenFalse() {
        Account<Car> account = new AccountParking(new ParkingCar("MEGA", 0, 0));
        Car passengerCar = new PassengerCar("UAZ", 1);
        Car track = new Track("KAMAZ", 2);
        assertFalse(account.enterCar(passengerCar));
        assertFalse(account.enterCar(passengerCar));
        assertFalse(account.enterCar(track));
        assertFalse(account.enterCar(track));
    }

    @Ignore
    @Test
    public void whenExitCarThenTrue() {
        Account<Car> account = new AccountParking(new ParkingCar("MEGA", 2, 0));
        Car track = new Track("KAMAZ", 2);
        account.enterCar(track);
        assertTrue(account.exitCar(track));
    }

    @Ignore
    @Test
    public void whenExitCarThenFalse() {
        Account<Car> account = new AccountParking(new ParkingCar("MEGA", 2, 0));
        Car track = new Track("KAMAZ", 2);
        assertTrue(account.exitCar(track));
    }

    @Ignore
    @Test
    public void whenTrackEnterInPassengerCarPlaceIsSmallerThanTruckSize() {
        Account<Car> account = new AccountParking(new ParkingCar("MEGA", 0, 2));
        Car track = new Track("Kamaz", 3);
        assertFalse(account.enterCar(track));
    }

    @Ignore
    @Test
    public void whenTrackEnterSize2InPassengerCarPlaceSize3ThanTruckEnter() {
        Account<Car> account = new AccountParking(new ParkingCar("MEGA", 0, 3));
        Car track = new Track("Kamaz", 2);
        Car passengerCar = new PassengerCar("Lada", 1);
        assertTrue(account.enterCar(track));
        assertFalse(account.enterCar(track));
        assertTrue(account.enterCar(passengerCar));
    }

    @Ignore
    @Test
    public void whenPassengerCarEnterThePlaceTruckThenFalse() {
        Account<Car> account = new AccountParking(new ParkingCar("Mega", 2, 0));
        Car passengerCar = new PassengerCar("Lada", 1);
        assertFalse(account.enterCar(passengerCar));
    }
}