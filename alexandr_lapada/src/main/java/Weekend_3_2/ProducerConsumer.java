package Weekend_3_2;

/**
 * Created by sanya on 25.01.2015.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Holder hold = new Holder();
        Produser produser = new Produser(hold);
        Consumer consumer = new Consumer(hold);
        produser.start();
        consumer.start();
    }

}

class Produser extends Thread{
    private Holder holder;
    public Produser() {
         holder = new Holder();
    }
    public Produser(Holder holder){
        this.holder = holder;
    }

    @Override
    public void run(){
        for (int i = 0; i < 200; i++){
            holder.setValue(i);
        }
    }

}

class Consumer extends Thread{
    private Holder holder;

    public Consumer() {
        holder = new Holder();
    }
    public Consumer(Holder holder){
        this.holder = holder;
    }

    @Override
    public void run(){
        for (int i = 0; i < 200; i++){
            System.out.println(holder.getValue());
            holder.setValue(null);
        }

    }

}

class Holder{

    private Integer value;

    public synchronized void setValue(Integer value){
        this.value = value;
    }

    public synchronized Integer getValue(){
        return value;
    }


}
