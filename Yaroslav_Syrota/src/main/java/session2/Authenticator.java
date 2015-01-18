package session2;

import java.util.HashSet;
/*import java.util.Iterator;
import java.util.Set;*/

/**
 * Created with IntelliJ IDEA.
 * User: Yaroslav_Syrota
 * Date: 17.01.15
 */
public class Authenticator {
    private HashSet<User> users = new HashSet<User>();

    private static final Authenticator AUTHENTICATOR = new Authenticator();

    public Authenticator(){}


    public void addUser(String l, String p) {
        users.add(new User(l, p));
    }

    public User getUser(String l) {
        User u = new User();
        for(User x : users) {
            if(x.getLogin().equals(l)) u = x;
        }
        return u;
    }

    public boolean auth(User u, String p) {
        if(u.getPass().equals(p)) return true;
        else return false;
    }

    public boolean auth(String l, String p) {
        boolean s = false;
        for(User x : users) {
            if(x.getLogin().equals(l) && x.getPass().equals(p)) s = true;
        }
        return s;
    }

}
/*
private HashSet<User> users = new HashSet<User>();

	public static final Authon AUTHON = new Authon();

	private Authon(){}






 */