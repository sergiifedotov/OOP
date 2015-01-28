package hw2.park;

import java.util.HashMap;

/**
 * При создании парковки создаем сразу места с номерами
 * Смотрим какие свободные места
 * Добавляем машину в готовое место
 * При выезде машины, парко-место остается
 */
public class Parking {

    private HashMap<Integer,Car> listOfParkedCars;
    private int size;

    public Parking(int size){
        listOfParkedCars = new HashMap<>();
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int park(Car car) throws Exception{
        if (listOfParkedCars.size()==size) throw new ParkFullException();
        int carHashCode = car.hashCode();

        listOfParkedCars.put(carHashCode,car);
        return carHashCode;
    }

    public Car leave(int placeNumber) throws Exception{
        if (!listOfParkedCars.containsKey(placeNumber)) throw new IndexOutOfBoundsException();
        return listOfParkedCars.remove(placeNumber);
    }

    class ParkFullException extends Exception {
        public ParkFullException() {}
        public ParkFullException(String msg) {super(msg);}
    }
}
