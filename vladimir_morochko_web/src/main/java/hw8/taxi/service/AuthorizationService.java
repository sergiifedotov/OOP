package hw8.taxi.service;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthorizationException;

/**
 * Created by vladimir on 03.03.2015.
 */
public interface AuthorizationService {

    boolean register(String login, String accessId, String password) throws AuthorizationException;

    Operator getOperatorByLogin(String login);
}
