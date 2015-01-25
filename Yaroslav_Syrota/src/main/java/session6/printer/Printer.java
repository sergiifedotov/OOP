package session6.printer;

/**
 * Created by Yaroslav_Syrota on 25.01.2015.
 */
public class Printer {
    public Printer() {}

    public synchronized static void print(String str) {
        System.out.print("[");
        sleep();
        System.out.print(str);
        sleep();
        System.out.println("]");
    }

    public static void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
