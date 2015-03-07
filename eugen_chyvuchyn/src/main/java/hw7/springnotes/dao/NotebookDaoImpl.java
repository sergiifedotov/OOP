package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chuvychin on 27.02.2015.
 */

@Repository
public class NotebookDaoImpl implements NotebookDao{

    @Autowired
    private SessionFactory factory;

    public NotebookDaoImpl() {
    }


    @Override
    public Long create(Notebook notebook) {
        Session session = factory.getCurrentSession();
        Long id = (long)session.save(notebook);
        return id;
    }

    @Override
    public Notebook read(Long ig) {
        Session session = factory.getCurrentSession();
        return  (Notebook)session.get(Notebook.class, ig);

    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.getCurrentSession();
        session.update(notebook);
        return true;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.getCurrentSession();
        session.delete(notebook);
        return true;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Notebook.class).list();
    }
}
