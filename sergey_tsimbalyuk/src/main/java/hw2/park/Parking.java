package hw2.park;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Sergey Tsimbalyuk
 * on 26.02.15 // 0:29
 */
public class Parking {
    private static final int MAX_NUMBER_OF_PLACES = 6;
    private final Map<Integer, Car> parking;

    public Parking() {
        parking = new TreeMap<>();
        for (int i = 1; i < MAX_NUMBER_OF_PLACES; i++) {
            parking.put(i, null);
        }
    }

    public static void main(String[] args) {
        Parking p = new Parking();
        try {
            System.out.println(p.park(new Car("opel1")));
            System.out.println(p.park(new Car("opel2")));
            System.out.println(p.park(new Car("opel3")));
            System.out.println(p.park(new Car("opel4")));
            System.out.println(p.park(new Car("opel5")));

        } catch (ParkFullException e) {
            e.printStackTrace();
        }

        System.out.println(p.leave(1));
        System.out.println(p.leave(2));
        System.out.println(p.leave(3));
        System.out.println(p.leave(4));
        System.out.println(p.leave(5));
     }

    public int park(Car car) throws ParkFullException {
        for (Map.Entry<Integer, Car> each : parking.entrySet()) {
            if (each.getValue() == null) {
                each.setValue(car);
                return each.getKey();
            }
        }
        throw new ParkFullException();
    }

    public Car leave(int placeNumber) throws IndexOutOfBoundsException {
        if (placeNumber < 1 || placeNumber > MAX_NUMBER_OF_PLACES - 1)
            throw new IndexOutOfBoundsException("Wrong place number");
        Car car;
        for (Map.Entry<Integer, Car> each : parking.entrySet()) {
            if (each.getKey() == placeNumber) {
                car = each.getValue();
                each.setValue(null);
                return car;
            }
        }
        return null;
    }
}
class ParkFullException extends Exception {
    public ParkFullException() {
        super("Parking is full");
    }
}
class Car {
    private final String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" + "model='" + model + '\'' + '}';
    }
}

class ParkingTest {
}