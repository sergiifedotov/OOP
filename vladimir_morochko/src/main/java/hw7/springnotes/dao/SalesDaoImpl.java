package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 23.02.2015.
 */
@Repository
@Transactional
public class SalesDaoImpl implements SalesDao {
    @Autowired(required = true)
    SessionFactory sessionFactory; // фабрика берется из контекста

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
    public boolean update(Sales sales) {
        sessionFactory.getCurrentSession().update(sales);
        return true;
    }

    @Override
    public boolean delete(Sales sales) {
        sessionFactory.getCurrentSession().delete(sales);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sales> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Sales.class);
        return (List<Sales>) criteria.list();
    }
}
