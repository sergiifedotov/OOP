package hw9.taxi.dao;

import hw9.taxi.domain.Order;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Repository
public class OrderDaoImpl implements OrderDao {
    private static Logger log = Logger.getLogger(OrderDaoImpl.class);

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(Order order) {
        return (Long) factory.getCurrentSession().save(order);
    }

    @Transactional(readOnly = true)
    @Override
    public Order read(Long id) {
        return (Order) factory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public boolean update(Order order) {
        factory.getCurrentSession().update(order);
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getOrdersByPortion(int size) {
        Session session = factory.getCurrentSession();

        List list = session.createCriteria(Order.class).setFirstResult(0).setMaxResults(size).list();
        if(list.size()>0){
            return list;
        }

        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getOrdersGtSum(int sum) {
        Session session = factory.getCurrentSession();

        List list = session.createCriteria(Order.class).add(Restrictions.eq("sum", sum)).list();

        if(list.size()>0){
            return list;
        }

        return null;
    }

}
