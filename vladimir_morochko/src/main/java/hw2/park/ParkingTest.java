package hw2.park;

/**
 * Created by vladimir on 23.01.2015.
 */
public class ParkingTest {
    public static void main(String[] args) {
        Parking parking = new Parking();


        try {
            parking.park(new Car("Honda", "red"));
            parking.park(new Car("Toyota", "blue"));
            parking.park(new Car("Nissan", "black"));
        } catch (Parking.ParkFullException e) {
            System.out.println(e);
        }
        System.out.println(parking);

        try {
            parking.park(new Car("Mercedes", "grey"));
            parking.park(new Car("BMW", "white"));
            parking.park(new Car("Opel", "yellow"));
            parking.park(new Car("Ford", "green"));
            parking.park(new Car("Chrysler", "black"));
            parking.park(new Car("Fiat", "blue"));
            parking.park(new Car("Bentley", "british racing green"));
            parking.park(new Car("Ferrari", "red"));
            parking.park(new Car("Tesla", "red"));
            parking.park(new Car("Zapor", "red"));
        } catch (Parking.ParkFullException e) {
            System.out.println(e);
        }
        System.out.println(parking);

        try {
            System.out.println(parking.leave(1) + " has left");
        } catch (Parking.IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println(parking);

        try {
            parking.leave(1);
        } catch (Parking.IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
