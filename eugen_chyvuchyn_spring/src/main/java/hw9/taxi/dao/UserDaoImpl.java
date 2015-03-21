package hw9.taxi.dao;

import hw9.taxi.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Chuvychin on 13.03.2015.
 */
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory factory;

    public UserDaoImpl() {
    }

    @Override
    public Long create(User user) {
        Session session = factory.getCurrentSession();
        Long id = (long)session.save(user);
        return id;
    }

    @Override
    public User read(Long id) {
        Session session = factory.getCurrentSession();
        return (User)session.get(User.class,id);
    }

    @Override
    public User readByLogin(String login) {
        Session session = factory.getCurrentSession();
        return (User)session.get(User.class,login);
    }

    @Override
    public boolean update(User user) {
        Session session = factory.getCurrentSession();
        session.update(user);
        return true;
    }

    @Override
    public boolean delete(User user) {
        Session session = factory.getCurrentSession();
        session.delete(user);
        return true;
    }

    @Override
    public List<User> getAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(User.class).list();
    }
}
