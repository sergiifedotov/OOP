package hw2.park;

/**
 * Created by sanya on 19.01.2015.
 */
public class ParkingTest {
        public static void main(String[] args) throws  Parking.IndexOutOfBoundsException {
            Parking park = new Parking();

            Car car1 = new Car("Kia","Black","2121");
            Car car2 = new Car("Bmw","Black","6821");
            Car car3 = new Car("Mazda","White","2932");
            Car car4 = new Car("Honda","White","2123");
            Car car5 = new Car("Audi","Black","1232");
            Car car6 = new Car("Lexus","Black","2988");
            Car car7 = new Car("Toyota","Yellow","1313");
            Car car8 = new Car("Audi","Black","1232");
            Car car9 = new Car("Lexus","Black","2988");
            Car car10 = new Car("Toyota","Yellow","1313");


            int num1 = 0;
            try {
                num1 = park.park(car1);

                System.out.println("Номер машины 1 -" + num1);
                int num2 = park.park(car2);
                System.out.println("Номер машины 2 -" + num2);
                //System.out.println(park.leave(num1).getMarka()+ " Выехала 1-я с номером -" +num1);
                int num3 = park.park(car3);
                System.out.println("Номер машины 3 -" + num3);
                int num4 = park.park(car4);
                System.out.println("Номер машины 4 -" + num4);
                int num5 = park.park(car5);
                System.out.println("Номер машины 5 -" + num5);
                int num6 = park.park(car6);
                System.out.println("Номер машины 6 -" + num6);
                int num7 = park.park(car7);
                System.out.println("Номер машины 7 -" + num7);
                int num8 = park.park(car8);
                System.out.println("Номер машины 8 -" + num8);
                int num9 = park.park(car9);
                System.out.println("Номер машины 9 -" + num9);
                int num10 = park.park(car10);
                System.out.println("Номер машины 10 -" + num10);
            } catch (Parking.ParkFullException e) {
                e.printStackTrace();
            }
            //Car carLeave = park.leave(num5);
            // System.out.println(park.leave(num5).getMarka()+ " Выехала 5-я с номером -" +num5);

        }
    }


