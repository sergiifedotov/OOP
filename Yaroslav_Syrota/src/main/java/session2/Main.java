package session2;

/**
 * Created with IntelliJ IDEA.
 * User: Yaroslav_Syrota
 * Date: 17.01.15
 */
public class Main {
    public static void main(String[] args) {
        Authenticator authenticator = new Authenticator();
        authenticator.addUser("pol", "poli");
        System.out.println(authenticator.auth("pol", "poli"));
    }
}
