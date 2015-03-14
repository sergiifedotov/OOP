package hw9.taxi.service;

import hw9.taxi.exception.AuthenticationException;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
public interface AuthorizationService {
    boolean register(String login, String id, String pass) throws AuthenticationException;
}
