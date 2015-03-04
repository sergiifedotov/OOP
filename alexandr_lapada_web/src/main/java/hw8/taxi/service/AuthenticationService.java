package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

/**
 * Created by sanya on 03.03.2015.
 */
public interface AuthenticationService {

    boolean authenticate(String login, String pass) throws AuthenticationException;
    boolean register(String login, String id, String pass) throws AuthenticationException;
    public boolean changePass();
}
