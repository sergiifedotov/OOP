package dreamteam.service;

import hw9.taxi.exception.AuthenticationException;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String password) throws AuthenticationException;

    void close();
}
