package session5;

/**
 * Created by vladimir on 25.01.2015.
 */
public class PrinterTest {
    public static void main(String[] args) {
        PrinterThread th1 = new PrinterThread("thread1");
        PrinterThread th2 = new PrinterThread("thread2");
        PrinterThread th3 = new PrinterThread("thread3");
        th1.start();
        th2.start();
        th3.start();
    }
}
