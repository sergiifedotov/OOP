package hw8.taxi.service;

import hw8.taxi.exception.AuthorizationException;

/**
 * Created by sanya on 03.03.2015.
 */
public interface AuthorizationService {

    boolean authenticate(String login, String pass) throws AuthorizationException;
    boolean register(String login, String id, String pass) throws AuthorizationException;
    public boolean changePass();
}
