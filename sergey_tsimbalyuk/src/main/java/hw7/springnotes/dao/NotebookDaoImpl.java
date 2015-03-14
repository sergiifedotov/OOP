package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
public class NotebookDaoImpl implements NotebookDao {
    private Logger log = Logger.getLogger(NotebookDaoImpl.class);

    @Qualifier("mySessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Notebook notebook) {
        return (Long) sessionFactory.getCurrentSession().save(notebook);
    }

    @Transactional(readOnly = true)
    @Override
    public Notebook read(Long id) {
        return (Notebook) sessionFactory.getCurrentSession().get(Notebook.class, id);
    }

    @Override
    public boolean update(Notebook notebook) {
        sessionFactory.getCurrentSession().update(notebook);
        return true;
    }

    @Override
    public boolean delete(Notebook notebook) {
        sessionFactory.getCurrentSession().delete(notebook);
        return true;
    }

    @Override
    public List<Notebook> findAll() {
        return (List<Notebook>) sessionFactory.getCurrentSession().createCriteria(Notebook.class).list();
    }

    @Override
    public List<Notebook> getPortion(Integer firstResult, Integer maxResult) {
        Session session = null;
        List<Notebook> list = null;
        try{
            session = sessionFactory.openSession();
            list = session.createCriteria(Notebook.class).setFirstResult(firstResult).setMaxResults(maxResult).list();
        } catch (HibernateException e){
            log.error(e);
        } finally {
            if (session != null){
                session.close();
            }
        }
        return list;
    }
}