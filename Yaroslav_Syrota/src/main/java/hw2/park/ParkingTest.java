package hw2.park;

/**
 * Created by Yaroslav_Syrota on 19.01.2015.
 */
public class ParkingTest {
    public static  void main(String[] args) {
        Parking parking = new Parking();

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        int m1 = parking.park(car1);
        int m2 = parking.park(car2);
        int m3 = parking.park(new Car());
        int m4 = parking.park(car3);

        Car res1 = parking.leave(1);
        Car res2 = parking.leave(3);
        Car res3 = parking.leave(8);
        Car res4 = parking.leave(52);


    }
}
