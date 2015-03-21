package hw9.taxi.dao;

import hw9.taxi.domain.Operator;
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
public class OperatorDaoImpl implements OperatorDao {
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public OperatorDaoImpl() {
    }

    @Override
    public Long create(Operator operator) {
        return (Long) sessionFactory.getCurrentSession().save(operator);
    }

    @Override
    @Transactional(readOnly = true)
    public Operator read(Long id) {
        return (Operator) sessionFactory.getCurrentSession().get(Operator.class, id);
    }

    @Override
    public boolean update(Operator operator) {
        sessionFactory.getCurrentSession().update(operator);
        return true;
    }

    @Override
    public boolean delete(Operator operator) {
        sessionFactory.getCurrentSession().delete(operator);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Operator.class);
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public Operator getOperatorByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Operator.class).add(Restrictions.eq("login", login));
        return (Operator) criteria.uniqueResult();
    }
}
