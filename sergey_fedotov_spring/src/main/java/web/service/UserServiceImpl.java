package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;

/**
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public UserServiceImpl(UserDao dao) {
        userDao = dao;
    }

    public UserServiceImpl() {
    }

    @Override
    public boolean authenticate(String login, String pass) {
        return userDao.authenticate(login, pass);
    }
}
