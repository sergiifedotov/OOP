package hw9.taxi.dao;

import hw9.taxi.domain.Order;
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
public class OrderDaoImpl implements OrderDao {
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public OrderDaoImpl() {
    }

    @Override
    public Long create(Order order) {
        return (Long) sessionFactory.getCurrentSession().save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order read(Long id) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public boolean update(Order order) {
        sessionFactory.getCurrentSession().update(order);
        return true;
    }

    @Override
    public boolean delete(Order order) {
        sessionFactory.getCurrentSession().delete(order);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Order.class);
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List getOrders(Integer orderAmountLowerLimit, Integer orderAmountUpperLimit) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Order.class)
                .add(Restrictions.between("amount", orderAmountLowerLimit, orderAmountUpperLimit));
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List getOrdersByPortion(Integer portionSize) {
        int firstResult = 0;
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Order.class)
                .setFirstResult(firstResult)
                .setMaxResults(portionSize);
        return criteria.list();
    }
}
