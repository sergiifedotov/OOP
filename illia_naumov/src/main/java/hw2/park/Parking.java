package hw2.park;

import java.util.HashMap;
import java.util.Map;

/**
 * Написать класс представляющий парковку. С методами:
 - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
 Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException

 Написать модульный тест на класс Parking.

 Классы задания:
 hw2.park.Parking
 hw2.park.Car
 */

public class Parking {
    Map<Integer, Car> parking;

        public  Parking(){
            Map<Integer, Car> parking = new HashMap<Integer, Car>(20);
            for(int i = 1; i < 21; i++){
                parking.put(i, null);
            }
            /**for(Map.Entry<Integer, Car> entry : parking.entrySet()){
                  entry.set(i++);
            }*/
    }

    public Parking(int quantity){
        Map<Integer, Car> parking = new HashMap<Integer, Car>(quantity);
        for(int i = 1; i < quantity+1; i++){
            parking.put(i, null);
        }
    }
    public int park(Car car) throws ParkFullException {
        for (Map.Entry<Integer, Car> entry : parking.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue(car);
                return entry.getKey();
            } else {
                throw new ParkFullException();
            }

        }
        return -1;


    }

    public Car leave(int placeNumber){
        if(parking.containsKey(placeNumber)){
            Car car = parking.get(placeNumber);
            parking.put(placeNumber, null);
             return car;
        } else{
            throw new IndexOutOfBoundsException();
        }
    }

class ParkFullException extends Exception {
    public ParkFullException() {
        System.err.println("No more place");
    }
}

class Car {
    private final String companyName;
    private final String model;

    public Car(String companyName, String model, String owner){
        this.companyName = companyName;
        this.model = model;
    }

}
}