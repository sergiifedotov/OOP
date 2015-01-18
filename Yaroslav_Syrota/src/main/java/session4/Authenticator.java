package session4;

import session2.*;

import java.util.HashMap;

/**
 * Created by Yaroslav_Syrota on 18.01.2015.
 */
public class Authenticator {
    private HashMap<String, String> users = new HashMap<String, String>();

    private static final Authenticator AUTHENTICATOR = new Authenticator();

    public Authenticator(){}




    public boolean auth(String login, String password) {
        boolean b = false;
        if(users.containsKey(login)) {
            if(users.get(login).equals(password)) b = true;
        }
        return b;
    }
}
