package hw9.taxi.service;

import hw9.taxi.exception.AuthenticationException;

/**
 * Created by Chuvychin on 13.03.2015.
 */
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        return false;
    }
}
