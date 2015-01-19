package hw2.park;

/**
 * Created by Yaroslav_Syrota on 19.01.2015.
 */
public class Parking {
    private Car[] parkingSpaces = new Car[50];

    public Parking() {}


    public int park(Car car) {
        int number = -1;
        try {
            for (int i = 0; i <= parkingSpaces.length; i++) {
                if (parkingSpaces[i] == null) {
                    parkingSpaces[i] = car;
                    number = i;
                    break;
                }
            }
        } catch(ParkFullException e) {
            System.out.println(e);
        }
        return  number;
    }

    public Car leave(int placeNumber) {
        Car temp = null;
        try {
            temp = parkingSpaces[placeNumber];
            parkingSpaces[placeNumber] = null;
        } catch(IndexOutOfBoundsException e) {
            System.out.println("вы ввели неверный парковочный номер");
        }
        return temp;
    }

}

class ParkFullException extends ArrayIndexOutOfBoundsException {

    @Override
    public String toString() {
        return "вы ввели неверный парковочный номер";
    }
}
