package hw9.taxi.service;

import hw9.taxi.exception.AuthenticationException;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface AuthorizationService {
    boolean register(String login, String accessId, String password) throws AuthenticationException;
}
