package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by vladimir on 11.02.2015.
 *
 * service
 hw6.notes.service.NotebookService
 Long add(Notebook notebook)
 List<Notebook> findAll()
 hw6.notes.service.NotebookServiceImpl
 */

public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao = new NotebookDaoImpl();

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(NotebookDaoImpl notebookDaoImpl) {
        this.notebookDao = notebookDaoImpl;
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDao.findAll();
    }

    public void close() {
        notebookDao.close();
    }
}
