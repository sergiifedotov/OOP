package hw2.park;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by vladimir on 23.01.2015.
 *
 * Написать класс представляющий парковку. С методами:
 - int park(Car car) - поместить машину на парковку,
 возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки
 по номеру парокместа, возвращает удаляемую машину
 Методы выбрасывают ислключения IndexOutOfBoundsException и
 ParkFullException

 Написать модульный тест на класс Parking.

 Классы задания:
 hw2.park.Parking
 hw2.park.Car

 */
public class Parking {
    private HashMap<Integer, Car> parking;
    private Integer parkingCapacity;

    public Parking() {
        parking = new HashMap<Integer, Car>();
        parkingCapacity = new Integer(10);
    }

    public Parking(Integer parkingCapacity) {
        this();
        this.parkingCapacity = parkingCapacity;
    }

    public int park(Car car) throws ParkFullException{
        if (parking.size() == parkingCapacity) {
            throw new ParkFullException();
        } else {
            int currentPlace = 0;
            while (parking.get(currentPlace) != null) {
                currentPlace++;
            }
            parking.put(currentPlace, car);
            return currentPlace;
        }
    }

    public Car leave(int placeNumber) throws IndexOutOfBoundsException {
        Car carToGet = parking.get(placeNumber);
        if (carToGet == null) {
            throw new IndexOutOfBoundsException();
        } else {
            parking.remove(placeNumber);
            return carToGet;
        }
    }

    @Override
    public String toString() {
        String stringToReturn = new String();
        Iterator<Map.Entry<Integer, Car>> iterator = parking.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Car> currentEntry = iterator.next();
            stringToReturn += currentEntry.getKey() + ". "
                    + currentEntry.getValue() + "\n";
        }
        return stringToReturn;
    }

    public class ParkFullException extends Exception {
        public ParkFullException() {
            super("ParkFullException");
        }
    }

    public class IndexOutOfBoundsException extends Exception {
        public IndexOutOfBoundsException() {
            super("IndexOutOfBoundsException");
        }
    }

}
