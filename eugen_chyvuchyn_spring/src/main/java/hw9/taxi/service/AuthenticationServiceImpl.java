package hw9.taxi.service;

import hw9.taxi.dao.UserDao;
import hw9.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chuvychin on 13.03.2015.
 */
@Component
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserDao userDao;

    public AuthenticationServiceImpl() {
    }


    @Override
    @Transactional (readOnly = true)

    public boolean authenticate(String login, String pass) throws AuthenticationException {
        if (userDao.readByLogin(login).getPass() == pass){
            return true;
        } else {
            return false;
        }
    }
}
