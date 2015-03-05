package hw8.taxi.service;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;

/**
 * Created by Tanya on 04.03.2015.
 */
public interface AuthenticationService {
    public boolean authenticate(String login, String pass) throws AuthenticationException;
    public boolean register(String login, String id, String pass) throws AuthenticationException;
    public Long create(Operator operator);
    public boolean findLoginInBase(String login);
}