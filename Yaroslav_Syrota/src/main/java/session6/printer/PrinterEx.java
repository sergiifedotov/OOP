package session6.printer;

/**
 * Created by Admin on 25.01.2015.
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
