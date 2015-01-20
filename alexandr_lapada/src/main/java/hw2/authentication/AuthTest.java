package hw2.authentication;

/**
 * Created by sanya on 20.01.2015.
 */
public class AuthTest {
    public static void main(String[] args) {
        Auth auth = new Auth();

        auth.add("sasha","123");
       // auth.remove("sasha");
       // auth.add("sasha","123");

        System.out.println(auth.authenticate("sasha","123456"));

    }
}
