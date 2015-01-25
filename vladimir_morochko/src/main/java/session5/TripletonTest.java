package session5;


/**
 * Created by vladimir on 24.01.2015.
 */
public class TripletonTest {
    public static void main(String[] args) {
        Tripleton tripleton1 = Tripleton.getInstance();
        Tripleton tripleton2 = Tripleton.getInstance();
        Tripleton tripleton3 = Tripleton.getInstance();

        if (tripleton1 != tripleton2
                && tripleton2 != tripleton3
                && tripleton3 != tripleton1) {
            System.out.println("ok");
        }

     }
}
