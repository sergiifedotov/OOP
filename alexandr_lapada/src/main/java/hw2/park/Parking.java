package hw2.park;
import java.util.HashMap;

/**
 * Created by sanya on 19.01.2015.
 */
public class Parking {
    private HashMap<Integer,Car> parking;
    private int numberOfPlace = 0;
    private static int freePlaces = 10;

    public Parking(){
        parking = new HashMap<Integer,Car>();
    }

    public int park(Car car) throws ParkFullException{
       if(freePlaces<1){ throw new ParkFullException(); }

        numberOfPlace = 1+(int)(Math.random()*10);

        while (parking.get(numberOfPlace)!=null) {
            numberOfPlace = 1+(int)(Math.random()*10);
        }

        parking.put(numberOfPlace, car);
        freePlaces--;
        return (numberOfPlace);
    }

    public Car leave(int placeNumber) throws IndexOutOfBoundsException{
        Car car = parking.get(placeNumber);
        if(car == null){ throw new IndexOutOfBoundsException();}
        parking.remove(placeNumber);
        freePlaces++;
        return(car);
    }
    public class IndexOutOfBoundsException extends Exception{}
    public class ParkFullException extends Exception {

        @Override
        public String toString() {
            return "мест нет";
        }

    }

}
