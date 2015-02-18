package session5;

/**
 * Created by ZaR on 24.01.15.
 */
public class Threeton2 {
    private static Threeton2 instance1;
    private static int count;


    private Threeton2(){
    }

    public synchronized static Threeton2 getInstance1(){
        if(count++ <= 3) {
            instance1 = new Threeton2();
        }
        return instance1;
    }



}
