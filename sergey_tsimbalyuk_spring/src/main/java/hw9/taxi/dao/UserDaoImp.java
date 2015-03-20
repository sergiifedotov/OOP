package hw9.taxi.dao;

import hw9.taxi.domain.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */


public class UserDaoImp implements UserDao {
//    private static Logger log = Logger.getLogger(UserDaoImp.class);
    @Autowired
    SessionFactory factory;

    public UserDaoImp(final SessionFactory factory) {
        this.factory = factory;
    }

    public UserDaoImp() {
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
    public User readByLogin(final String login) {
        Session session = factory.getCurrentSession();
        return (User)session.get(User.class,login);
//        final List<User> users = factory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("login", login)).list();
//        return null == users || users.isEmpty() ? null : users.get(0);
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
    public List<User> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(User.class).list();
        // без Session session = **** return factory.getCurrentSession().createCriteria(User.class).list();
    }
}