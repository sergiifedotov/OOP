package main.java.session4;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.01.15
 */
public class Authenticator {
    private Map<String, String> users;

    public Authenticator() {
    }

    public boolean auth (String login, String pass) {
        if (users.containsKey(login) && users.get(login).equals(pass)) {
            return true;
        }
        return false;
    }

    public boolean auth1 (String login, String pass) {
        return users.containsKey(login) && users.get(login).equals(pass);
    }

    public boolean auth2 (String login, String pass) {
        for (Map.Entry<String, String> entry : users.entrySet()) {
            if (entry.getKey().equals(login) && entry.getValue().equals(pass)) {
                return true;
            }
        }
        return false;
    }
}
