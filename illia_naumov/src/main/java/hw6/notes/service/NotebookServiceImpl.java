package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by user on 10.02.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDaoImpl notebookDao;
    public NotebookServiceImpl(NotebookDaoImpl notebookDao){
        this.notebookDao = notebookDao;
    }
    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDao.findAll();
    }
}
