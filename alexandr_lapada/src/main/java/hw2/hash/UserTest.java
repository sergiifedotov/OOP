package hw2.hash;

/**
 * Created by sanya on 20.01.2015.
 */
public class UserTest {
    public static void main(String[] args) {
        User user1 = new User("sasha","qwerty","29.12.1988",66,"male");
        User user2 = new User("ira","qwerty","29.12.1988",89,"female");
        User user3 = new User("sasha","qwerty","29.12.1988",66,"male");
        User user4 = new User();

        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(user3));

        System.out.println(user1.equals(user1));
        System.out.println(user1.equals(user4));

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
        //System.out.println(user4.hashCode());

    }
}
