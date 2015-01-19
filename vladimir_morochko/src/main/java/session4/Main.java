package session4;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.01.15
 */
public class Main {
    public static void main(String[] args) {
        Authenticator authenticator = new Authenticator();
        System.out.println(authenticator.auth("1", "1"));
        System.out.println(authenticator.auth("2", "2"));
        System.out.println(authenticator.auth("1", "3"));
    }
}
