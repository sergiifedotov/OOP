package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

/**
 * Created by Konstantin on 02.03.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
}
