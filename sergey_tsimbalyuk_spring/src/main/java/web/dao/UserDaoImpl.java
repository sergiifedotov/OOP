package web.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.domain.User;

import java.util.List;

/**
 * Created by tsv on 07.03.15.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static Logger log = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory factory;

    public UserDaoImpl() {
    }

    @Transactional
    @Override
    public void create(User user) {
        Session session = factory.getCurrentSession();
        try {
            session.save(user);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            e.printStackTrace();
        }
    }

    @Override
    public User read(Long id) {
        Session session = factory.getCurrentSession();
        try {
            return (User) session.get(User.class, id);
        } catch (HibernateException e) {
            log.error("Fetch error", e);
        }
        return null;
    }

    @Override
    public void update(User user) {
        Session session = factory.getCurrentSession();
        try {
            session.save(user);
        } catch (HibernateException e) {
            log.error("Transaction failed");
        }

    }

    @Override
    public void delete(User user) {
        Session session = factory.getCurrentSession();
        try {
            session.delete(user);
        } catch (HibernateException e) {
            log.error("Transaction failed");
        }

    }

    @Override
    public List<User> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(User.class).list();
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = factory.getCurrentSession();
        List<User> users = session.createCriteria(User.class).add(Restrictions.eq("login", login)).list();
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;

    }

}
