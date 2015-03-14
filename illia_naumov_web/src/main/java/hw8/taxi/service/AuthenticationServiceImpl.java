package hw8.taxi.service;

import hw8.taxi.domain.User;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by illia_naumov on 06.03.2015.
 */
public class AuthenticationServiceImpl implements AuthenticationService {
    public static HashMap<String, User> usersMap = new HashMap<String, User>();
    int attempts;

    public AuthenticationServiceImpl() throws IOException {
        attempts = Integer.parseInt((new PropertiesValueGetter()).getAttempts());
        AuthenticationServiceImpl.usersMap.put("dima", new User(1, "dima"));
        AuthenticationServiceImpl.usersMap.put("vano", new User(2, "vano"));
    }

    public static void main(String[] args) {

    }

    @Override
    public boolean authenticate(String login, String pass) {
        User user = usersMap.get(login);
        if (usersMap.containsKey("dima") && user.getPassword().equals(pass) && user.isBlocked() == false) {
            user.setAuthTries(0);
            return true;
        } else {
            user.setAuthTries(user.getAuthTries() + 1);
            if (user.getAuthTries() >= attempts) {
                user.setBlocked(true);
            }
            return false;
        }
    }
}
