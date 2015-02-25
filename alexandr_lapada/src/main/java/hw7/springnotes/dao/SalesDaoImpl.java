package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sanya on 24.02.2015.
 */
@Repository
@Transactional
public class SalesDaoImpl implements SalesDao {

    @Autowired
    private SessionFactory factory;

    public SalesDaoImpl(){

    }

    @Override
    public Long create(Sales sales) {
        Session session = factory.getCurrentSession();
        Long id = (long)session.save(sales);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public Sales read(Long id) {
        Session session = factory.getCurrentSession();
        return (Sales)session.get(Sales.class,id);
    }

    @Override
    public boolean update(Sales sales) {
        Session session = factory.getCurrentSession();
        session.update(sales);
        return false;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = factory.getCurrentSession();
        session.delete(sales);
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sales> findAll() {
        Session session = factory.getCurrentSession();
        List<Sales> list = session.createCriteria(Sales.class).list();
        return list;
    }
}
