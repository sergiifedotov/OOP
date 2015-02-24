package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class NotebookDaoImpl implements NotebookDao {
    @Qualifier("mySessionFactoryHW7")
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public NotebookDaoImpl() {
    }

    @Override
    public Long create(Notebook notebook) {
        return (Long) sessionFactory.getCurrentSession().save(notebook);
    }

    @Override
    @Transactional(readOnly = true)
    public Notebook read(Long id) {
        return (Notebook) sessionFactory.getCurrentSession().get(Notebook.class, id);
    }

    @Override
    public void update(Notebook notebook) {
        sessionFactory.getCurrentSession().update(notebook);
    }

    @Override
    public void delete(Notebook notebook) {
        sessionFactory.getCurrentSession().delete(notebook);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notebook> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Notebook.class);
        return criteria.list();
    }
}
