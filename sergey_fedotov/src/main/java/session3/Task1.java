package session3;

/**
 * Created by warit on 17.01.2015.
 */
public class Task1 {

    public static void main(String[] args) {

        Authenticator authenticator = new Authenticator();
        authenticator.addMemberList(new User("Иван","1"));
        authenticator.addMemberList(new User("Петр","2"));
        authenticator.addMemberList(new User("Света","3"));
        authenticator.addMemberList(new User("Катя","4"));

        System.out.println(authenticator.auth("Иван","1"));
        System.out.println(authenticator.auth("Оля","1"));
        System.out.println(authenticator.auth("Катя","4"));
    }

}
