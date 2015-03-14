package hw9.taxi.dao;

import hw9.taxi.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sanya on 12.03.2015.
 */
@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(Order order) {
        Session session = factory.getCurrentSession();
        return (long)session.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order read(Long id) {
        Session session = factory.getCurrentSession();
        return (Order)session.get(Order.class,id);
    }

    @Override
    public boolean update(Order order) {
        Session session = factory.getCurrentSession();
        session.update(order);
        return true;
    }

    @Override
    public boolean delete(Order order) {
        Session session = factory.getCurrentSession();
        session.delete(order);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Order.class).list();
    }

    @Override
    public List<Order> findAllByPortion(int first, int result) {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Order.class).setFirstResult(first).setMaxResults(result).list();
    }

    @Override
    public List<Order> findAllDiapasonSumm(Double sumFrom, Double sumTo) {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Order.class).add(Restrictions.gt("summa",sumFrom)).add(Restrictions.lt("summa",sumTo)).list();
    }
}
