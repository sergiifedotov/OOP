package hw9.taxi.service;

import hw9.taxi.exception.AuthenticationException;

/**
 * Created by sanya on 10.03.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
}
