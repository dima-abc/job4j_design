package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Класс описывающий хранилище парковки.
 *
 * @author Dmitry
 * @since 10.02.2022.
 */
public class ParkingCarTest {
    @Ignore
    @Test
    public void whenGetAddressThenMEGA() {
        Parking<Car> parking = new ParkingCar("MEGA", 6, 2);
        assertThat(parking.getAddress(), is("MEGA"));
    }

    @Ignore
    @Test
    public void whenGetCountTrackThen6() {
        Parking<Car> parking = new ParkingCar("MEGA", 6, 2);
        assertThat(parking.getCountTrack(), is(6));
    }

    @Ignore
    @Test
    public void whenGetCountPassengerCarThen2() {
        Parking<Car> parking = new ParkingCar("MEGA", 6, 2);
        assertThat(parking.getCountPassengerCar(), is(2));
    }

    @Ignore
    @Test
    public void whenAddCarTrackThenTrue() {
        Parking<Car> parking = new ParkingCar("MEGA", 6, 2);
        Car car = new PassengerCar("UAZ", 1);
        Car track = new Track("KAMAZ", 3);
        parking.addCar(car);
        parking.addCar(car);
        assertTrue(parking.addCar(track));
    }

    @Ignore
    @Test
    public void whenAddCarTrackThenFalse() {
        Parking<Car> parking = new ParkingCar("MEGA", 0, 1);
        Car track = new Track("KAMAZ", 2);
        assertFalse(parking.addCar(track));
    }

    @Ignore
    @Test
    public void whenAddCarTrackToPassengerPlaceThenTrue() {
        Parking<Car> parking = new ParkingCar("MEGA", 0, 3);
        Car track = new Track("KAMAZ", 2);
        assertTrue(parking.addCar(track));
    }

    @Ignore
    @Test
    public void whenAddCarPassengerCarThenTrue() {
        Parking<Car> parking = new ParkingCar("MEGA", 0, 2);
        Car car = new PassengerCar("UAZ", 1);
        parking.addCar(car);
        assertTrue(parking.addCar(car));
    }

    @Ignore
    @Test
    public void whenAddCarPassengerCarThenFalse() {
        Parking<Car> parking = new ParkingCar("MEGA", 0, 2);
        Car car = new PassengerCar("UAZ", 1);
        parking.addCar(car);
        parking.addCar(car);
        assertFalse(parking.addCar(car));
    }

    @Ignore
    @Test
    public void whenDeleteCarThenTrue() {
        Parking<Car> parking = new ParkingCar("MEGA", 0, 2);
        Car car = new PassengerCar("UAZ", 1);
        parking.addCar(car);
        assertTrue(parking.deleteCar(car));
    }

    @Ignore
    @Test
    public void whenDeleteCarThenFalse() {
        Parking<Car> parking = new ParkingCar("MEGA", 6, 2);
        Car car = new PassengerCar("UAZ", 1);
        assertFalse(parking.deleteCar(car));
    }

    @Ignore
    @Test
    public void whenAddTrackToTrackPlaceAndCarPlace() {
        Parking<Car> parking = new ParkingCar("MEGA", 2, 3);
        Car track = new Track("KAMAZ", 3);
        assertTrue(parking.addCar(track));
        assertTrue(parking.addCar(track));
        assertTrue(parking.addCar(track));
    }

    @Ignore
    @Test
    public void whenAddPassengerCarToTrackPlaceAndCarPlace() {
        Parking<Car> parking = new ParkingCar("MEGA", 2, 1);
        Car passengerCar = new PassengerCar("UAZ", 1);
        assertTrue(parking.addCar(passengerCar));
        assertTrue(parking.addCar(passengerCar));
        assertTrue(parking.addCar(passengerCar));
    }

    @Ignore
    @Test
    public void whenAddTrackAndGetCountTrackThen2() {
        Parking<Car> parking = new ParkingCar("MEGA", 3, 0);
        Car track = new Track("KAMAZ", 2);
        assertThat(parking.getCountTrack(), is(2));
    }
}