package main.java.session5;

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
        Printer printer = Printer.getInstance();
        for (int i=0; i < 20; i++) {
            printer.print(getName());
        }
    }
}

class Printer {
    private static Printer instance = new Printer();

    private Printer() {}

    public static Printer getInstance() {
        return instance;
    }

    public void print(String str) {
        synchronized (this) {
            System.out.print("[");
            sleep();
            System.out.print(str);
            sleep();
            System.out.println("]");
        }
    }

    public void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}