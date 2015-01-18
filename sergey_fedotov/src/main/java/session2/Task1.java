package session2;

import java.util.Scanner;

/**
 * Created by warit on 11.01.2015.
 */
public class Task1 {

    public static Object getConsoleVar(){

        Scanner scan = new Scanner(System.in);
        try {
            double rezult = scan.nextDouble();
            return rezult;
        } catch (Exception e){}

        try {
            int rezult = scan.nextInt();
            return rezult;
        } catch (Exception e){}

        try {
            String rezult = scan.nextLine();
            return rezult;
        } catch (Exception e){}

        return 0;
    }

    public static void main(String[] args){
        System.out.println("Введите данные в консоль");
        long time1 = System.nanoTime();
        long time2 = System.nanoTime();
        System.out.println(getConsoleVar());
        long score = time2 - time1;
        System.out.println(score);
    }

}
