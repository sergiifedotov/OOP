package hw8.taxi.dao;

import hw8.taxi.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
@Repository
@Transactional
public class OperatorDaoImpl implements OperatorDao {
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public OperatorDaoImpl() {
    }

    @Override
    public Long create(User operator) {
        return (Long) sessionFactory.getCurrentSession().save(operator);
    }

    @Override
    @Transactional(readOnly = true)
    public User read(Long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public boolean update(User operator) {
        sessionFactory.getCurrentSession().update(operator);
        return true;
    }

    @Override
    public boolean delete(User operator) {
        sessionFactory.getCurrentSession().delete(operator);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public User getOperatorByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }
}
