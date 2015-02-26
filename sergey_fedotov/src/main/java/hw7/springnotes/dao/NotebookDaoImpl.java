package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Store;
import hw7.springnotes.domain.Vendor;
import hw7.springnotes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Repository
@Transactional
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    @Autowired
    private SessionFactory factory;


    public static void main(String[] args) {

        NotebookDaoImpl notebookDaoImpl = new NotebookDaoImpl();


        System.out.println(notebookDaoImpl.findAll().toString());

    }

    public NotebookDaoImpl() {

    }

    @Override
    public Long create(Notebook notebook) {
        return (Long) factory.getCurrentSession().save(notebook);
    }

    @Override
    @Transactional(readOnly = true)
    public Notebook read(Long id) {
        return (Notebook) factory.getCurrentSession().get(Notebook.class,id);
    }

    @Override
    public boolean update(Notebook notebook) {
        factory.getCurrentSession().update(notebook);
        return true;
    }

    @Override
    public boolean delete(Notebook notebook) {
        factory.getCurrentSession().delete(notebook);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> getNotebooksByPortion(int size) {
        return factory.getCurrentSession().createCriteria(Notebook.class).setFirstResult(0).setMaxResults(size).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return factory.getCurrentSession().createCriteria("stores").add(Restrictions.gt("amount", amount)).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return factory.getCurrentSession().createCriteria(Notebook.class)
                .createCriteria("cpu")
                .add(Restrictions.eq("vendor", cpuVendor)).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> getNotebooksFromStore() {

        return factory.getCurrentSession().createCriteria(Store.class)
                .setProjection(Projections.property("notebook")).list();

    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> getNotebooksStorePresent() {
        return factory.getCurrentSession().createCriteria(Notebook.class).createCriteria("stores").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> findAll() {
        return factory.getCurrentSession().createCriteria(Notebook.class).list();
    }

}