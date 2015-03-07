package homework2;
/**
 * Created by stan on 17.02.15.
 */
import java.util.Map;
import java.util.TreeMap;


public class Parking {
    private static final int common_numbers_of_places = 6;
    private final Map<Integer, Car> parking;

    public Parking() {
        parking = new TreeMap<>();
        for (int i = 1; i < common_numbers_of_places; i++) {
            parking.put(i, null);
        }
    }


    public Car leave(int placeNumber) throws IndexOutOfBoundsException {
        if (placeNumber < 1 || placeNumber > common_numbers_of_places - 1)
            throw new IndexOutOfBoundsException("indentified place number");
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

    public int park(Car car) throws ParkFullException {
        for (Map.Entry<Integer, Car> each : parking.entrySet()) {
            if (each.getValue() == null) {
                each.setValue(car);
                return each.getKey();
            }
        }
        throw new ParkFullException();
    }



    public static void main(String[] args) {
        Parking park = new Parking();
        try {
            System.out.println(park.park(new Car("car1")));
            System.out.println(park.park(new Car("car2")));
            System.out.println(park.park(new Car("car3")));
            System.out.println(park.park(new Car("car4")));
            System.out.println(park.park(new Car("car5")));

        } catch (ParkFullException exc) {
            exc.printStackTrace();
        }

        System.out.println(park.leave(1));
        System.out.println(park.leave(2));
        System.out.println(park.leave(3));
        System.out.println(park.leave(4));
        System.out.println(park.leave(5));
    }
}
class ParkFullException extends Exception {
    public ParkFullException() {
        super("There are no any empty places");
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