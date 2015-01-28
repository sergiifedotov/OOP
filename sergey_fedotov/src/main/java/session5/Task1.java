package session5;

/**
 * Created by warit on 24.01.2015.
 */
public class Task1 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }
}
class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}

class Singleton2 {
    private static Singleton instance;

    private Singleton2() {
    }

    public synchronized static Singleton getInstance() {
        if (instance==null){
            //instance = new Singleton();
        }
        return instance;
    }
}
