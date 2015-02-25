package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 23.02.2015.
 */
@Repository
@Transactional
public class SalesDaoImpl implements SalesDao {
    @Qualifier("mySessionFactoryHW7")
    @Autowired(required = true)
    private SessionFactory sessionFactory; // фабрика берется из контекста

    public SalesDaoImpl() {
    }

    @Override
    public Long create(Sales sales) {
        return (Long) sessionFactory.getCurrentSession().save(sales);
    }

    @Override
    @Transactional(readOnly = true)
    public Sales read(Long id) {
        return (Sales) sessionFactory.getCurrentSession().get(Sales.class, id);
    }

    @Override
    public void update(Sales sales) {
        sessionFactory.getCurrentSession().update(sales);
    }

    @Override
    public void delete(Sales sales) {
        sessionFactory.getCurrentSession().delete(sales);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sales> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Sales.class);
        return criteria.list();
    }

    @Override
    public List<Sales> getSalesByDays() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Sales.class)
                .addOrder(Order.asc("date"));
        return criteria.list();
    }
}
