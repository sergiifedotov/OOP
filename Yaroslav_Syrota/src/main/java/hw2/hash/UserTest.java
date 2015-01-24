package hw2.hash;

/**
 * Created by Yaroslav_Syrota on 19.01.2015.
 */

public class UserTest {
    public  static void main(String[] args) {
        User user1 = new User();
        user1.setLogin("vasiliy");
        user1.setPassword("petrov");
        User user2 = new User("neo", "izbranniy", true);
        User user3 = new User();
        
        int h1 = user1.hashCode();
        System.out.println(h1);
        int h2 = user2.hashCode();
        System.out.println(h2);
        int h3 = user3.hashCode();
        System.out.println(h3);

        boolean b1 = user1.equals(user2);
        System.out.println(b1);
        boolean b2 = user3.equals(user1);
        System.out.println(b2);
        boolean b3 = user2.equals(user3);
        System.out.println(b3);
    }
}
