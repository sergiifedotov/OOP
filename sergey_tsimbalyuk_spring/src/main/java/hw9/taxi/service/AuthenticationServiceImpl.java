package hw9.taxi.service;

import hw9.taxi.dao.UserDaoImp;
import hw9.taxi.domain.User;
import hw9.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    public UserDaoImp userDao;

    @Override
    @Transactional
    public boolean authenticate(String login, String pass) throws AuthenticationException {

        return false;
    }

    @Override
    @Transactional
    public User getUser(String login) {
        return null;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return null;
    }

    public UserDaoImp getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImp userDao) {
        this.userDao = userDao;
    }
}