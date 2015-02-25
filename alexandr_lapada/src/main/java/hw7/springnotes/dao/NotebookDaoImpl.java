package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sanya on 24.02.2015.
 */
@Repository
@Transactional
public class NotebookDaoImpl implements NotebookDao {

    @Autowired
    private SessionFactory factory;

    public NotebookDaoImpl(){

    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.getCurrentSession();
        Long id = (long)session.save(notebook);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public Notebook read(Long id) {
        Session session = factory.getCurrentSession();
        return (Notebook)session.get(Notebook.class,id);
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.getCurrentSession();
        session.update(notebook);
        return false;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.getCurrentSession();
        session.delete(notebook);
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> findAll() {
        Session session = factory.getCurrentSession();
        List<Notebook> list = session.createCriteria(Notebook.class).list();
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> getPortion(Integer first, Integer result) {
        Session session = factory.getCurrentSession();
        List<Notebook> list = session.createCriteria(Notebook.class).setFirstResult(first).setMaxResults(result).list();
        return list;
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        Session session = factory.getCurrentSession();
        List<Notebook> list = session.createCriteria(Notebook.class).createCriteria("stores").add(Restrictions.gt("quantity",amount)).list();
        return list;
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        Session session = factory.getCurrentSession();
        System.out.println("*******"+cpuVendor.getName()+"*********");
        List<Notebook> list = session.createCriteria(Notebook.class).createCriteria("cpu").add(Restrictions.eq("vendor",cpuVendor.getName())).list();
        return list;
    }
}
