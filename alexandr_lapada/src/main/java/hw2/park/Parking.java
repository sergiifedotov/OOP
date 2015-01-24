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
       if(freePlaces<1){ throw new ParkFullException("Мест нет"); }

        numberOfPlace = 1+(int)(Math.random()*9);

        while (parking.get(numberOfPlace)!=null) {
            numberOfPlace = 1+(int)(Math.random()*9);
        }

        parking.put(numberOfPlace, car);
        freePlaces--;
        return (numberOfPlace);
    }

    public Car leave(int placeNumber){
        Car car = parking.get(placeNumber);
        parking.remove(placeNumber);
        freePlaces++;
        return(car);
    }

    public class ParkFullException extends Exception {

    public ParkFullException(String message) {
        super(message);
    }


    }

}
