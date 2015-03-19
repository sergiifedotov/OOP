package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

/**
 * Created by illia_naumov on 10.03.2015.
 */
public interface AuthorizationService {
    boolean register(String login, long id, String pass) throws AuthenticationException;
}
