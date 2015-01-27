package Session3_4_DZ;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Chuvychin on 22.01.2015.

 Написать класс представляющий парковку. С методами:
 - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
 Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException

 Написать модульный тест на класс Parking.

 Классы задания:
 hw2.park.Parking
 hw2.park.Car
 */
public class Parking {

    public static void main(String... args) throws ParkFullException, IndexOutOfBoundsException {
        Parking myParking = new Parking(10);
        Car myCar = new Car();

        //System.out.println();
        //System.out.println(myParking.park(myCar));
        //System.out.println(myParking.park(myCar));
        //System.out.println(myParking.park(myCar));
       // System.out.println(myParking.park(myCar));
        //System.out.println(myParking.park(myCar));
       // System.out.println(myParking.park(myCar));
        //System.out.println(myParking.leave(5));

        ParkingTest test = new ParkingTest();

        //System.out.println(test.testPark2());
        //test.testPark1();
        test.testLeave1();
        System.out.println(test.testLeave2());
    }


    private int carplaces;
    private Map<Integer, Car> parking = new HashMap<>(); //ключ - номер паркоместа, обьект - машина.

    public Parking(){

    }

    public Parking(int carplaces) {
        this.carplaces = carplaces;
    }

    public Car leave(int placeNumber) throws IndexOutOfBoundsException{
       try{ if (parking.get(placeNumber)==null ){
            throw new IndexOutOfBoundsException();
        }} catch (IndexOutOfBoundsException ex){
           ex.printStackTrace();
       }

        Car car = parking.get(placeNumber);
        parking.remove(placeNumber);

        return car;
    }


    public int park(Car car)throws ParkFullException{
        int place;
        if (checkParkingForPlace()<=0){
            throw new ParkFullException("Нет свободных мест на парковке");
        }

        Random rnd = new Random(System.currentTimeMillis());
        do {
            place = 1 + rnd.nextInt(carplaces);
        } while(parking.get(place)!= null);

        parking.put(place,car);
        return place;
    }

    public boolean checkPlacesForFree(int place){
        if (parking.get(place) ==null){
            return true;
        }

        return false;
    }

    public int checkParkingForPlace(){
        int freePlaces = this.carplaces - parking.size();
        return freePlaces;
    }

    public int getCarplaces() {
        return carplaces;
    }

}

class Car{
    private String number;
    public Car(){

    }

    public Car(String number){
        this.number = number;
    }
}

class ParkingTest{
    Car car1 = new Car();
    Car car2 = new Car("AABBCC");
    Parking parking1 = new Parking();
    Parking parking0 = new Parking(0);
    Parking parking2 = new Parking(50);

    public void testLeave1(){
        try {
            parking1.leave(2);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            parking0.leave(2);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            parking2.leave(51);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            car1 = parking2.leave(0);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public boolean testLeave2() throws ParkFullException, IndexOutOfBoundsException {
        int place = parking2.park(car2);
        Car car = parking2.leave(place);

        if (car2.equals(car) !=true){
            return false;
        }

        return true;
    }


    public void testPark1(){
        try {
            parking1.park(car1);
        } catch (ParkFullException ex){
            ex.printStackTrace();
        }
        try {
            parking0.park(car1);
        } catch (ParkFullException ex){
            ex.printStackTrace();
        }

    }

    public boolean testPark2(){
        try {
            if(parking2.park(car1)>50 || parking2.park(car1)<=0 ){
                return false;
            }
        } catch (ParkFullException e) {
            e.printStackTrace();
        }

        return true;
    }

}
class ParkFullException extends Exception{

    public ParkFullException(String message) {
        super(message);
    }

    public ParkFullException() {
        super();
    }

    @Override
    public void printStackTrace() {
        System.err.println("Нет свободных мест на парковке");
    }
}

class IndexOutOfBoundsException extends Exception{

    public IndexOutOfBoundsException(String message) {
        super(message);
    }

    public IndexOutOfBoundsException() {
        super();
    }

    @Override
    public void printStackTrace() {
        System.err.println("Машины нет на этом парковочном месте, или неверно введено значение");
    }
}

