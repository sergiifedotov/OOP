package session5;

/**
 * Created by ZaR on 24.01.15.
 */
public class Threeton {

    private static Threeton instance1;
    private static Threeton instance2;
    private static Threeton instance3;

    private Threeton(){
    }

    public synchronized static Threeton getInstance1(){
        if(instance1 == null) {
            instance1 = new Threeton();
        }
            return instance1;
    }

    public synchronized static Threeton getInstance2(){
        if(instance2 == null) {
            instance2 = new Threeton();
        }
        return instance2;
    }

    public synchronized static Threeton getInstance3(){
        if(instance3 == null) {
            instance3 = new Threeton();
        }
        return instance3;
    }







}
