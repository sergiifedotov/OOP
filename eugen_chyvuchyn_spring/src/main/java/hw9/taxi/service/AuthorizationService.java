package hw9.taxi.service;

import hw9.taxi.exception.AuthenticationException;

/**
 * Created by Chuvychin on 13.03.2015.
 */
public interface AuthorizationService {
    boolean register(String login, String id, String pass) throws AuthenticationException;
}
