package session6.task1;

/**
 * Created by warit on 25.01.2015.
 */
public class Printer {

    public static void print(String str) {
        System.out.print("[");
        sleep();
        System.out.print(str);
        sleep();
        System.out.print("]");
    }

    public static void sleep(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
