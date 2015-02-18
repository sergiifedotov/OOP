package session6;


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
    public  void run() {
        Printer printer = new Printer();
        for (int i=0; i < 20; i++) {
            printer.print(getName());
        }
    }
}

class Printer {
    public synchronized void print(String str) {
        System.out.print("[");
//        sleep();
        System.out.print(str);
//        sleep();
        System.out.print("]");
    }

    public void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

