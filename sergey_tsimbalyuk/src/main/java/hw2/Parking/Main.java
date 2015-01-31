package Parking;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean work = true;
       HashMap<Integer,Car> carMap = new HashMap<Integer, Car>();

        Scanner scanner = new Scanner(System.in);
        Parking parking = new Parking(5,carMap);
        parking.createMap(carMap,5);
        parking.menu(5,carMap);

    }
}
