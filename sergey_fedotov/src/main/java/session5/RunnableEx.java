package session5;

/**
 * Created by warit on 24.01.2015.
 */
public class RunnableEx implements Runnable {
    private Thread thread;

    public RunnableEx(){
        thread = new Thread(this);
    }

    @Override
    public void run() {

    }

    public void start(){
        thread.start();
    }

    public void stop(){
        thread.stop();
    }
}
