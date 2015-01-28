package session5;

/**
 * Created by warit on 24.01.2015.
 */
public class Tripleton {


    private static Tripleton instance;
    private static int count;

    private Tripleton() {
    }

    public synchronized static Tripleton getInstance() {

        if (count++<3){
            instance = new Tripleton();
        }

        return instance;
    }

}
