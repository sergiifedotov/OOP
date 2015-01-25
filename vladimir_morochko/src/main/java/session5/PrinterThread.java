package session5;

/**
 * Created by vladimir on 25.01.2015.
 */

public class PrinterThread implements Runnable {
    String name;
    private Thread thread;

    public PrinterThread() {
        thread = new Thread(this);
        //thread.start();
    }

    public PrinterThread(String name) {
        this.name = name;
        thread = new Thread(this);
        //thread.start();
    }

    @Override
    public void run() {
        Printer printer = Printer.getInstance();
        for (int i = 0; i < 20; i++) {
            printer.print(name);
        }
        return;

    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.stop();
    }

    public void interrupt() {
        thread.interrupt();
    }
}
