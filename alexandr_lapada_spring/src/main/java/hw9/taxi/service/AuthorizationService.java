package hw9.taxi.service;

import hw9.taxi.domain.User;
import hw9.taxi.exception.AuthenticationException;

/**
 * Created by sanya on 10.03.2015.
 */
public interface AuthorizationService {

    boolean register(String login, String id, String pass) throws AuthenticationException;
    Long create(User user);
}
