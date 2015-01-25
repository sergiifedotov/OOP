package Session5_6;

import org.omg.CORBA.TIMEOUT;

/**
 * Created by Chuvychin on 25.01.2015.
 * создаем обьект (полочка) с двумя методами положить и зарать
 один поток должен ложить (0-199), второй забирать(sout)
 */
public class Polochka {

    public static void main(String []args){
        Polochka polka = new Polochka();

        Consumer consumer = new Consumer(polka);
        Produser produser = new Produser(polka);

        consumer.start();
        produser.start();
    }

    private Integer baton = null;
    private static  int TIMEOUT = 10000;

    public synchronized Integer getBaton() throws InterruptedException {
        while (baton ==null){
                wait(TIMEOUT);
        }
        Integer tmp = baton;
        baton = null;
        notify();
        return tmp;

    }

    public synchronized void  setBaton(Integer value) throws InterruptedException {
        while (this.baton !=null) {

            wait(TIMEOUT);
        }
        this.baton = value;
        notify();
    }


}
class Consumer extends Thread{
    private Polochka polochka = new Polochka();

    public Consumer(Polochka holder){
        this.polochka = holder;
    }
    @Override

    public void run(){
        for(int i=0;i<200;i++){
            try {
                System.out.println(polochka.getBaton());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Produser extends Thread{
    private Polochka polochka = new Polochka();
    public Produser (Polochka holder){
        this.polochka = holder;
    }

    @Override
    public void run(){
        for(int i=0; i<200;i++){
            try {
                polochka.setBaton(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}