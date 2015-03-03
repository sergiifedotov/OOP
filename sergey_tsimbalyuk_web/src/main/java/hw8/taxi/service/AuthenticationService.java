package hw8.taxi.service;


import hw8.taxi.exception.AuthenticationException;

/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
}
