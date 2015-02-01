package session6.task4;

/**
 * Created by warit on 25.01.2015.
 */
public class ProducerConsumer {
    public static void main(String[] args) {

        Holder holder = new Holder();
        Producer producer = new Producer(holder);
        Consumer consumer = new Consumer(holder);

        producer.start();
        consumer.start();

    }

}

class Producer extends Thread{
    private Holder holder;

    public Producer(Holder holder){
        this.holder = holder;
    }
    @Override
    public void run(){
        for(int i=0; i<200;i++){
            try {
                holder.setValue(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer extends Thread{

    private Holder holder;

    public Consumer(Holder holder){
        this.holder = holder;
    }

    @Override
    public void run(){
        for(int i=0; i<200;i++){
            try {
                System.out.println(holder.getValue());;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Holder{
    private Integer value;
    private static int TIMEOUT = 10000;

    public boolean isFull(){
        return value!=null;
    }

    public synchronized Integer getValue()throws InterruptedException{
        while (!isFull()){
            wait(TIMEOUT);
        }
        Integer rezult = value;
        value = null;
        notify();
        return rezult;
    }

    public synchronized void setValue(Integer value) throws InterruptedException {
        while(isFull()){
            wait(TIMEOUT);
        }
        this.value = value;
        notify();
    }
}