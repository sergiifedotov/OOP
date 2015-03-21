package hw9.taxi.service;

import hw9.taxi.dao.UserDao;
import hw9.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by warit on 03.03.2015.
 */
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired(required = true)
    private UserDao userDao;

    public AuthenticationServiceImpl(UserDao dao) {
        userDao = dao;
    }

    public AuthenticationServiceImpl() {
    }

    @Override
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        return userDao.authenticate(login, pass);
    }
}
