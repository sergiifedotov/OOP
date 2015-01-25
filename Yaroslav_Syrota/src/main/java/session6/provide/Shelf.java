package session6.provide;

/**
 * Created by Yaroslav_Syrota on 25.01.2015.
 */
public class Shelf {
    public static Integer value;
    public static int TIMEOUT = 1000;
    public static final Shelf SHELF = new Shelf();

    private Shelf(){}

    public synchronized Integer getValue() throws InterruptedException{
        while(value==null) {
            wait(TIMEOUT);
        }
        int temp = value;
        value = null;
        notify();
        return temp;
    }

    public synchronized void setValue(Integer value) throws InterruptedException {
        while(this.value!=null) {
            wait(TIMEOUT);
        }
        this.value = value;
        notify();
    }
}
