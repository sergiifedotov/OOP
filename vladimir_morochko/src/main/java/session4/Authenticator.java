package session4;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.01.15
 *
 *
 */
public class Authenticator {
    private Map<String, String> users;

    public Authenticator() {
        users = new HashMap<>();

        users.put("1", "1");
        users.put("2", "2");

    }

    public boolean auth (String login, String pass) {
        return (users.containsKey(login) && users.get(login).equals(pass));
    }
}
