package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chuvychin on 27.02.2015.
 */
@Repository
public class SalesDaoImpl implements SalesDao {

    @Autowired
    private SessionFactory factory;

    public SalesDaoImpl() {
    }

    @Override
    public Long create(Sales sales) {
        Session session = factory.getCurrentSession();
        Long id = (long)session.save(sales);
        return id;
    }

    @Override
    public Sales read(Long ig) {
        Session session = factory.getCurrentSession();


        return (Sales)session.get(Sales.class, ig);
    }

    @Override
    public boolean update(Sales sales) {
        Session session = factory.getCurrentSession();
        session.update(sales);
        return true;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = factory.getCurrentSession();
        session.delete(sales);
        return true;
    }

    @Override
    public List<Sales> findAll() {
        Session session = factory.getCurrentSession();

        return session.createCriteria(Sales.class).list();
    }
}
