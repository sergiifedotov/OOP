package session5;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 25.01.15
 */
public class PrinterEx extends Thread {
    public static void main(String[] args) {
        PrinterEx th1 = new PrinterEx();
        PrinterEx th2 = new PrinterEx();
        PrinterEx th3 = new PrinterEx();
        th1.start();
        th2.start();
        th3.start();
    }

    @Override
    public void run() {
        for (int i=0; i < 20; i++) {
            Printer.print(getName());
        }
    }
}

class Printer {
    public static void print(String str) {
        System.out.println("[");
        sleep();
        System.out.println(str);
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