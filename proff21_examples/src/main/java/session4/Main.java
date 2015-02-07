package session4;

import session2.*;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 18.01.15
 */
public class Main {
    public static void main(String[] args) {
        Authenticator authenticator = new Authenticator();

        boolean resActual = authenticator.auth("1", "1");
        if (resActual == true) {
            System.out.println("TestOk");
        } else {
            System.out.println("Test failed");
        }

        System.out.println(authenticator.auth("1", "1"));
        System.out.println(authenticator.auth("1", "2"));
    }
}
