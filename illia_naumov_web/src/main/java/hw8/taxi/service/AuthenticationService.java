package hw8.taxi.service;


import hw8.taxi.exception.AuthenticationException;

/**
 * Created by illia_naumov on 06.03.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
}
