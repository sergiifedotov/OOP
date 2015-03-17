package hw7.springnotes.dao;


import hw7.springnotes.domain.Sales;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Repository
@Transactional
public class SalesDaoImpl implements SalesDao {
    @Qualifier("mySessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Sales sales) {
        return (Long) sessionFactory.getCurrentSession().save(sales);
    }

    @Transactional(readOnly = true)
    @Override
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
    public List<Sales> findAll() {
        return (List<Sales>) sessionFactory.getCurrentSession().createCriteria(Sales.class).list();
    }
}
