package hw9.taxi.dao;

import hw9.taxi.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sanya on 10.03.2015.
 */
@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(User user) {
        Session session = factory.getCurrentSession();
        return (long)session.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User read(Long id) {
        Session session = factory.getCurrentSession();
        return (User) session.get(User.class,id);
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
    @Transactional(readOnly = true)
    public List<User> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(User.class).list();
    }
}
