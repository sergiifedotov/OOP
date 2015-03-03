package hw8.taxi.service;

import javax.naming.AuthenticationException;

/**
 * Created by warit on 03.03.2015.
 */
public interface AuthenticationService {

    boolean authenticate(String login, String pass) throws AuthenticationException;

}
