package session5;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 25.01.15
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Holder holder = new Holder();
        new Producer(holder).start();
        new Consumer(holder).start();
    }
}

class Producer extends Thread {
    private Holder holer;

    public Producer(Holder holder) {
        this.holer = holder;
    }

    @Override
    public void run() {
        for (int i=0; i < 200; i++) {
            try {
                holer.setValue(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private Holder holer;

    public Consumer(Holder holder) {
        this.holer = holder;
    }

    @Override
    public void run() {
        for (int i=0; i < 200; i++) {
            try {
                System.out.println(holer.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Holder {
    private static int TIMEOUT = 10000;
    private Integer value = null;

    public synchronized Integer getValue() throws InterruptedException {
        while (value == null) {
            wait(TIMEOUT);
        }
        Integer tmp = value;
        value = null;
        notify();
        return tmp;
    }

    public synchronized void setValue(Integer value) throws InterruptedException {
        while (this.value != null) {
            wait(TIMEOUT);
        }

        this.value = value;
        notify();
    }
}
