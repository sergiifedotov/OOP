package hw9.taxi.service;


import hw9.taxi.exception.AuthenticationException;

/**
 * Created by warit on 03.03.2015.
 */
public interface AuthenticationService {

    boolean authenticate(String login, String pass) throws AuthenticationException;

}
