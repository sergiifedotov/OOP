package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.domain.User;

import java.util.List;

/**
 * Created by Chuvychin on 07.03.2015.
 */
@Repository
public class UserDaoImpl implements UserDao {

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
    public List<User> findByNameAndPass(String login, String pass) {
        Session session = factory.getCurrentSession();
        return (List<User>)session.createCriteria(User.class).add(Restrictions.eq("login", login)).add(Restrictions.eq("pass",pass)).list();
    }

    @Override
    public List<User> findAll() {
        Session session = factory.getCurrentSession();

        return session.createCriteria(User.class).list();
    }
}
