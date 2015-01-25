package session5;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.01.15
 */
public class RunnableEx implements Runnable {
    public static void main(String[] args) {
        RunnableEx thread = new RunnableEx();
        thread.start();
        thread.interrupt();
    }

    private Thread thread;

    public RunnableEx() {
        thread = new Thread(this);
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                // TODO complete all stuff
                return;
            }
        }
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



