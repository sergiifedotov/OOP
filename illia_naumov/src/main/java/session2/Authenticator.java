package main.java.session2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.01.15
 */
public class Authenticator {
    private Set<User> users;

    public Authenticator() {
        users = new HashSet<>();
        users.add(new User("1", "1"));
        users.add(new User("2", "2"));
        users.add(new User("3", "3"));
    }

    public boolean auth (String login, String pass) {
        Iterator<User> itr = users.iterator();
        while (itr.hasNext()) {
            User user = itr.next();
            if (user.getLogin().equals(login) && user.getPass().equals(pass)) {
                return true;
            }
        }
        return false;
//        return users.contains(new User(login, pass));
    }
}
