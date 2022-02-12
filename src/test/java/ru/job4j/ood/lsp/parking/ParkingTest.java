package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 2.5.3. LSP
 * 2. Парковка машин [#853]
 * Parking test.
 *
 * @author Dmitry
 * @since 10.02.2022.
 */
public class ParkingTest {
    @Test
    public void whenAddTrackInTrackParkingTrue() {
        Camp<Transport> parking = new Parking(1, 0);
        Transport truck = new Truck("r123er123");
        assertTrue(parking.enterTransport(truck));
    }

    @Test
    public void whenAddTrackInTrackParkingThenFalse() {
        Camp<Transport> parking = new Parking(1, 1);
        Transport truck = new Truck("r123er123");
        Transport truck2 = new Truck("b001ob001");
        parking.enterTransport(truck);
        assertFalse(parking.enterTransport(truck2));
    }

    @Test
    public void whenAddCarInPassengerParkingThenTrue() {
        Camp<Transport> parking = new Parking(3, 1);
        Transport car = new Car("r123er123");
        assertTrue(parking.enterTransport(car));
    }

    @Test
    public void whenAddCarInPassengerParkingThenFalse() {
        Camp<Transport> parking = new Parking(3, 1);
        Transport car = new Car("r123er123");
        Transport car1 = new Car("b001ob001");
        parking.enterTransport(car);
        assertFalse(parking.enterTransport(car1));
    }

    @Test
    public void whenAddTruckInPassengerParkingThenTrue() {
        Camp<Transport> parking = new Parking(1, 6);
        Transport truck = new Truck("r123er123", 3);
        Transport truck1 = new Truck("b001ob001", 3);
        Transport truck2 = new Truck("r161or161", 3);
        parking.enterTransport(truck);
        parking.enterTransport(truck1);
        assertTrue(parking.enterTransport(truck2));
    }

    @Test
    public void whenAddTruckInPassengerParkingThenFalse() {
        Camp<Transport> parking = new Parking(1, 3);
        Transport truck = new Truck("r123er123", 3);
        Transport truck1 = new Truck("b001ob001", 3);
        Transport truck2 = new Truck("r161or161", 3);
        parking.enterTransport(truck);
        parking.enterTransport(truck1);
        assertFalse(parking.enterTransport(truck2));
    }

    @Test
    public void whenEnterCarExitCarThenTrue() {
        Camp<Transport> parking = new Parking(3, 1);
        Transport car = new Car("r123er123");
        parking.enterTransport(car);
        assertTrue(parking.exitTransport(car));
    }

    @Test
    public void whenEnterThreeCarExitCarNumber2EnterCarNumber2ThenTrue() {
        Camp<Transport> parking = new Parking(0, 3);
        Transport car = new Car("r123er123");
        Transport car1 = new Car("b001ob001");
        Transport car2 = new Car("t161od161");
        parking.enterTransport(car);
        parking.enterTransport(car1);
        parking.enterTransport(car2);
        parking.exitTransport(car1);
        assertTrue(parking.enterTransport(car1));
    }

    @Test
    public void whenEnterTruckExitTruckThenTrue() {
        Camp<Transport> parking = new Parking(2, 0);
        Transport truck = new Truck("r123er123");
        parking.enterTransport(truck);
        assertTrue(parking.exitTransport(truck));
    }

    @Test
    public void whenEnterThreeTruckExitTruckNumber2EnterTruckNumber2ThenTrue() {
        Camp<Transport> parking = new Parking(3, 0);
        Transport truck = new Truck("r123er123");
        Transport truck1 = new Truck("b001ob001");
        Transport truck2 = new Truck("t161od161");
        parking.enterTransport(truck);
        parking.enterTransport(truck1);
        parking.enterTransport(truck2);
        parking.exitTransport(truck1);
        assertTrue(parking.enterTransport(truck1));
    }

    @Test
    public void whenEnterThreeTruckInParkingCarAndParkingTruckAndExitParkingExchangePointThenTrue() {
        Camp<Transport> parking = new Parking(2, 3);
        Transport truck = new Truck("r123er123");
        Transport truck1 = new Truck("b001ob001");
        Transport truck2 = new Truck("t161od161");
        Transport car = new Car("y333yx33");
        assertThat(parking.enterTransport(truck), is(true));
        assertThat(parking.enterTransport(truck1), is(true));
        assertThat(parking.enterTransport(car), is(true));
        assertThat(parking.enterTransport(truck2), is(true));
        assertThat(parking.exitTransport(truck1), is(true));
        assertThat(parking.exitTransport(truck2), is(true));
        assertThat(parking.exitTransport(car), is(true));
        assertThat(parking.enterTransport(truck2), is(true));
        assertThat(parking.enterTransport(truck1), is(true));
        assertThat(parking.enterTransport(car), is(true));
    }
}