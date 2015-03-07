package session6;

import static java.lang.Thread.sleep;

/**
 * Created by stan on 25.01.15.
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
    public void run(){
        for (int i=0; i<3; i++){
            Printer.print(getName());
        }
    }



}
class Printer{
    public synchronized static void  print  (String str) {

        System.out.print("[");
sleep();
        System.out.print(str);
        sleep();
        System.out.println("]");


    }

    public static void sleep() {
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }
}