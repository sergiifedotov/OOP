package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

/**
 * Created by Tanya on 05.03.2015.
 */
public interface AuthorizationService {
    boolean register(String login, String id, String pass) throws AuthenticationException;
}
