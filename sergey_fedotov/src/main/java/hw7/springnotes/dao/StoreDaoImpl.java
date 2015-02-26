package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;
import hw7.springnotes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Repository
@Transactional
public class StoreDaoImpl implements StoreDao {
    private static Logger log = Logger.getLogger(StoreDaoImpl.class);

    @Autowired
    private SessionFactory factory;


    public static void main(String[] args) {

        StoreDaoImpl storeDaoImpl = new StoreDaoImpl();

        System.out.println(storeDaoImpl.findAll().toString());

    }

    public StoreDaoImpl() {

    }

    @Override
    public Long create(Store store) {
        return (Long) factory.getCurrentSession().save(store);
    }

    @Override
    @Transactional(readOnly = true)
    public Store read(Long id) {
        return (Store) factory.getCurrentSession().get(Store.class,id);
    }

    @Override
    public boolean update(Store store) {
        factory.getCurrentSession().update(store);
        return true;
    }

    @Override
    public boolean delete(Store store) {
        factory.getCurrentSession().delete(store);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Store> findAll() {
        return (List)factory.getCurrentSession().createCriteria(Store.class).list();
    }

}