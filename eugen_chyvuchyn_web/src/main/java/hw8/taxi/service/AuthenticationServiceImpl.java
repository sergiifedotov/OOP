package hw8.taxi.service;

import hw8.taxi.exception.AuthenticationException;

/**
 * Created by Chuvychin on 06.03.2015.
 */
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        return false;
    }
}
