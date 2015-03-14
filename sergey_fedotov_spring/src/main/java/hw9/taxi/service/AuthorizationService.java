package hw9.taxi.service;

import hw9.taxi.exception.AuthenticationException;

/**
 *
 */
public interface AuthorizationService {

    boolean register(String login, String id, String pass) throws AuthenticationException;

}
