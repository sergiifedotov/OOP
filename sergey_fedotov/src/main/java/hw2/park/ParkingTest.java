package hw2.park;

import java.util.HashMap;

/**
 * Created by warit on 22.01.2015.
 */
public class ParkingTest {

    public static int parkTest(String nameTest, Parking parking, Car car, boolean rezult){
        boolean rez;
        int placeNumber=0;
        try {
            placeNumber = parking.park(car);
            rez = true;
        } catch (Exception e) {
            //e.printStackTrace();
            rez = false;
        }
        if (rez==rezult) {
            System.out.println(nameTest.concat("completed successfully"));}
        else
        {System.err.println(nameTest.concat("error"));}

        return placeNumber;
    }

    public static void leaveTest(String nameTest, Parking parking, int placeNumber, boolean rezult){
        boolean rez;
        try {
            Car car = parking.leave(placeNumber);
            rez = true;
        } catch (Exception e) {
            //e.printStackTrace();
            rez = false;
        }
        if (rez==rezult) {
            System.out.println(nameTest.concat("completed successfully"));}
        else
        {System.err.println(nameTest.concat("error"));}
    }

    public static void main(String[] args) {

        Parking parking = new Parking(100);

        Car car1 = new Car("Ivan");
        Car car2 = new Car("758");
        Car car3 = new Car("000");

        String nameTest;

        nameTest = "parkTest1:";
        Integer placeNumber=0;
        placeNumber = parkTest(nameTest, parking, car1, true);

        nameTest = "parkTest2:";
        placeNumber = parkTest(nameTest, new Parking(0), car1, false);

        nameTest = "parkTest3:";
        int placeNumber2=0;
        placeNumber2 = parkTest(nameTest, parking, car2, true);

        nameTest = "leaveTest1:";
        leaveTest(nameTest, parking, placeNumber2, true);

        nameTest = "leaveTest2:";
        leaveTest(nameTest, parking, 0, false);

        nameTest = "leaveTest3:";
        leaveTest(nameTest, new Parking(0), 0, false);

    }
}
