package session5;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.01.15
 */
public class Tripleton {
    private static Tripleton instance;
    private static int count;

    private Tripleton() {
    }

    public static synchronized Tripleton getInstance() {
        if (count++ < 3) {
            instance = new Tripleton();
        }
        return instance;
    }
}
