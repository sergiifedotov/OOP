package hw7.notes.dao;

import hw7.notes.domain.Notebook;
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
public class NotebookDaoImpl implements NotebookDao{
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
}