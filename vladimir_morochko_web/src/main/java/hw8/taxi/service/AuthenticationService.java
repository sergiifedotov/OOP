package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

/**
 * Created by vladimir on 03.03.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String password) throws AuthenticationException;
}
