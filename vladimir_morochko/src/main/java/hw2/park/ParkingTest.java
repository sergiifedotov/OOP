package hw2.park;

/**
 * Created by vladimir on 23.01.2015.
 */
public class ParkingTest {
    public static void main(String[] args) {
        Parking myParking = new Parking();


        try {
            myParking.park(new Car("Honda", "red"));
            myParking.park(new Car("Toyota", "blue"));
            myParking.park(new Car("Nissan", "black"));
        } catch (Parking.ParkFullException e) {
            System.out.println(e);
        }
        System.out.println(myParking);

        try {
            myParking.park(new Car("Mercedes", "grey"));
            myParking.park(new Car("BMW", "white"));
            myParking.park(new Car("Opel", "yellow"));
            myParking.park(new Car("Ford", "green"));
            myParking.park(new Car("Chrysler", "black"));
            myParking.park(new Car("Fiat", "blue"));
            myParking.park(new Car("Bentley", "british racing green"));
            myParking.park(new Car("Ferrari", "red"));
            myParking.park(new Car("Tesla", "red"));
            myParking.park(new Car("Zapor", "red"));
        } catch (Parking.ParkFullException e) {
            System.out.println(e);
        }
        System.out.println(myParking);

        try {
            System.out.println(myParking.leave(1) + " has left");
        } catch (Parking.IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println(myParking);

        try {
            myParking.leave(1);
        } catch (Parking.IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
