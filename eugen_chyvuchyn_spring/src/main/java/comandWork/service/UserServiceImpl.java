package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.domain.User;

import java.util.List;

/**
 * Created by Chuvychin on 07.03.2015.
 */
@Component
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Override
    public Long add(User user) {
        return userDao.create(user);
    }

    @Override
    @Transactional (readOnly = true)
    public User read(Long id) {
        return userDao.read(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findByNameAndPass(String login, String pass) {
        return userDao.findByNameAndPass(login,pass);
    }

}
