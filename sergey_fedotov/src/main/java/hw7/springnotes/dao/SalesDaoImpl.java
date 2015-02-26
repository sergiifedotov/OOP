package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Sales;
import hw7.springnotes.domain.Store;
import hw7.springnotes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository
@Transactional
public class SalesDaoImpl implements SalesDao {
    private static Logger log = Logger.getLogger(SalesDaoImpl.class);

    @Autowired
    private SessionFactory factory;


    public static void main(String[] args) {

        SalesDaoImpl salesDaoImpl = new SalesDaoImpl();

        System.out.println(salesDaoImpl.findAll().toString());

    }

    public SalesDaoImpl() {

    }

    @Override
    public Long create(Sales sales) {
        return (Long) factory.getCurrentSession().save(sales);
    }

    @Override
    @Transactional(readOnly = true)
    public Sales read(Long id) {
        return (Sales) factory.getCurrentSession().get(Sales.class,id);
    }

    @Override
    public boolean update(Sales sales) {
        factory.getCurrentSession().update(sales);
        return true;
    }

    @Override
    public boolean delete(Sales sales) {
        factory.getCurrentSession().delete(sales);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sales> findAll() {
        return (List)factory.getCurrentSession().createCriteria(Sales.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public Map<Notebook, Integer> getSalesByDays() {
        Map<Notebook, Integer> map = new HashMap<>();
        List list = factory.getCurrentSession().createCriteria(Sales.class).list();
        if (list != null) {
            Iterator<Sales> iterator = list.iterator();
            while (iterator.hasNext()) {
                Sales sales = iterator.next();
                Integer amount = sales.getAmount();
                Store store = sales.getStore();
                Notebook notebook = store.getNotebook();
                map.put(notebook, amount);
            }
        }
        return map;
    }

}