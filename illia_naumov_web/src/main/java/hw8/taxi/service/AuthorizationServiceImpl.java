package hw8.taxi.service;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.User;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.exception.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by illia_naumov on 10.03.2015.
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService{
    @Autowired(required = true)
    private OperatorDao operatorDao;

    public AuthorizationServiceImpl() {

    }

    @Override
    public boolean register(String login, long id, String pass) throws AuthorizationException {
        if(operatorDao.getOperatorByLogin(login) == null){
            operatorDao.create(new User(login, id, pass));
            return true;
        } else {
            throw new AuthorizationException("This login \"" + login + "\" is already occupied");

        }
    }
}
