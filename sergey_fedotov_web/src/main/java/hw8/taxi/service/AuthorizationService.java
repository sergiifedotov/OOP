package hw8.taxi.service;

import hw8.taxi.exception.AuthorizationException;

/**
 * Created by warit on 03.03.2015.
 */
public interface AuthorizationService {

    boolean register(String login, String id, String pass) throws AuthorizationException;

}
