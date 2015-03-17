package hw9.taxi.dao;

import hw9.taxi.domain.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @Autowired
    SessionFactory factory;

    private static Logger log = Logger.getLogger(UserDaoImp.class);

    @Override
    @Transactional
    public User read(String login) {
        return (User)factory.getCurrentSession().get(User.class, login);
    }

    @Override
    public List<User> findAll() {
        Session session = null;
        List <User> list = new ArrayList<>();
        try {
            session = factory.openSession();
            return session.createCriteria(User.class).list();
        } catch (HibernateException e) {
            log.error("error");
            session.getTransaction().rollback();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean add(User user) {
        Session session = null;
        try {
            session = factory.openSession();
            session.update(user);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Add failed");
            session.getTransaction().rollback();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        Session session = null;
        try {
            session = factory.openSession();
            session.delete(user);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Delete failed");
            session.getTransaction().rollback();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }
}