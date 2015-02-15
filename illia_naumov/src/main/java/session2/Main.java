package main.java.session2;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.01.15
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("trololo");
        Authenticator authenticator = new Authenticator();
        System.out.println(authenticator.auth("1", "1"));
        System.out.println(authenticator.auth("1", "2"));
    }
}
