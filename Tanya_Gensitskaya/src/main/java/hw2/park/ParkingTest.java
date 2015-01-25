package hw2.park;

/**
 * Created by Tanya on 21.01.2015.
 */
public class ParkingTest {
    public static void main(String[] args) {

        testPark();
        testLeave();
    }
    public static boolean testPark()  {
        Car car1 = new Car(17811);
        Parking park = new Parking();
        int expected = 4;
        int actually = 0;
        for(int i=0; i<expected; i++){
            actually = park.park(car1);
        }
        if(actually == expected ){ //
            System.out.println("Test park success ");
            return true;
        }else {
            System.out.println("Test park failed");
            return false;
        }
    }

    public static boolean testLeave()  {
        Car car1 = new Car(17811);
        Parking park = new Parking();
        int expected = 3;
        int actually = 0;
        for(int i=0; i<= expected; i++){
            actually = park.park(car1);
        }
        park.leave(1);
        actually--;
        if(actually == expected ){ //
            System.out.println("Test park success ");
            return true;
        }else {
            System.out.println("Test park failed");
            return false;
        }
    }
}
