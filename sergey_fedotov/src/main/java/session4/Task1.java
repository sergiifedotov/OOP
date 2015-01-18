package session4;


/**
 * Created by warit on 17.01.2015.
 */
public class Task1 {

    public static void main(String[] args) {

        Authenticator authenticator = new Authenticator();
        authenticator.addMemberList("Иван","1");
        authenticator.addMemberList("Петр","2");
        authenticator.addMemberList("Света","3");
        authenticator.addMemberList("Катя","4");

        System.out.println(authenticator.auth("Иван","1"));
        System.out.println(authenticator.auth("Оля","1"));
        System.out.println(authenticator.auth("Катя","4"));
    }

}
