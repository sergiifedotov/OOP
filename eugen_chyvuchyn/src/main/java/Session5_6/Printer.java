package Session5_6;

/**
 * Created by Chuvychin on 25.01.2015.
 */
public class Printer {

    public static void main(String...args){
        PrinterEx th1 = new PrinterEx();
        PrinterEx th2 = new PrinterEx();
        PrinterEx th3 = new PrinterEx();

        th1.start();
        th2.start();
        th3.start();

    }



    private static Printer instance = new Printer();

    public static Printer getInstance() {
        return instance;
    }

    public synchronized void print(String str) throws InterruptedException {
            System.out.print("[ ");
            sleep();
            System.out.print(str);
            sleep();
            System.out.println(" ]");
    }

   public void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class PrinterEx extends Thread{

    @Override
    public void run(){

        Printer printer = Printer.getInstance();
        for (int i=0; i<20;i++){
            try {
                printer.print(getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}