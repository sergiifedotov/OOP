package Parking;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Parking {
private int parkingPlace;
private Map<Integer,Car> carMap= new HashMap<Integer, Car>();

    public int getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(int parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public Map<Integer, Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<Integer, Car> carMap) {
        this.carMap = carMap;
    }

    public Parking(int parkingPlace, Map<Integer, Car> carMap) {
        this.parkingPlace = parkingPlace;
        this.carMap = carMap;
    }
    public void createMap(Map<Integer,Car> carMap,int parkingPlace){
        for (int i = 0; i <parkingPlace ; i++) {
            int k = i;
            carMap.put(k,null);

        }
    }
    public boolean checkFree (Map<Integer,Car> carMap){


            boolean  check = false;
        for (int i = 0; i <carMap.size() ; i++) {



             if (carMap.get(i)!=null){
                System.out.println(i + " место Занято");
                check = false;
            }else  if (carMap.get(i)==null){
                 System.out.println(i + " Parking place IS EMPTY ");
                 check = true ;
             }

        }




         return  check;
    }


    public void putCar(int parkingPlace,HashMap<Integer,Car> carMap){

        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("Parking place");
            int parking = scanner.nextInt();

            if (carMap.get(parking) !=null){
                System.out.println("ERROR PARKING PLACE  IS NOT EMPTY");
                return;
            }






            System.out.print("Please write a number of car:");
            int carNumber = scanner.nextInt();



                System.out.print("Введите владельца машины");
                String nameOfOwner = scanner.next().toString();
                System.out.print("Please Write a model:");
                String model = scanner.next().toString();
                Car car = new Car(carNumber, model, nameOfOwner);
                carMap.put(parking, car);
                System.out.println("Машина на стоянке"+parking);

        }  catch (InputMismatchException number){
            System.out.println("Invalid Command");




    }
    }
    public void removeCar(int parkingPlace,  HashMap<Integer, Car> carMap) {
        boolean test = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write a parking place of removed car:");
        int writedNumber = scanner.nextInt();
         carMap.remove(writedNumber);
        System.out.println("Car removed");

        }
    public void menu(int parkingPlace,HashMap<Integer,Car> carMap){
        boolean test1 = true;


        Scanner s = new Scanner(System.in);
        try {


            while ( test1 = true) {

                boolean checkfree = checkFree(carMap);
                System.out.println("1.Добавить машину на стоянку");
                System.out.println("2.удалить машину со стоянки");
                System.out.println("3.");
                System.out.print("\n\n Write a number of command:");
                int command = s.nextInt();
                if (command == 1) putCar(parkingPlace,carMap);
                if (command == 2) removeCar(parkingPlace, carMap);
                if (command ==3);
                if (command > 3) {
                    System.out.println("Error");
                };

    }


        } catch (InputMismatchException command    )  {
            System.out.println(" Invalid format of command");

        }     finally {
            s.close();
        }
    }

}




