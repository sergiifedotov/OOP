package Weekend_3_2;

/**
 * Created by sanya on 25.01.2015.
 */
public class Printer extends Thread {

    private  static Printer instance = new Printer();
    private Printer(){

    }

    public static Printer getInstance(){
        return instance;
    }

    @Override
    public void run() {
        Printer printer = Printer.getInstance();
        try {
            for (int i = 0; i < 20; i++) {
                printer.print(this.getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void print(String str) throws InterruptedException {
        System.out.print("[");
        Thread.sleep(1);
        System.out.print(str);
        Thread.sleep(1);
        System.out.print("]");
        System.out.println();
    }

}



