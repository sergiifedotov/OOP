package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by sanya on 10.02.2015.
 */
public class NotebookDaoImpl implements NotebookDao{
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        return null;
    }

    @Override
    public Notebook read(Long id) {
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        return false;
    }

    @Override
    public List<Notebook> findAll() {
        return null;
    }
}
