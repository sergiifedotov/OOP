package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by sanya on 11.02.2015.
 */
public class NotebookServiceImpl implements NotebookService{
    NotebookDaoImpl notebookDaoImpl;
    public NotebookServiceImpl(NotebookDaoImpl notebookDao){
        this.notebookDaoImpl = notebookDao;
    }
    @Override
    public Long add(Notebook notebook) {
        return notebookDaoImpl.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDaoImpl.findAll();
    }
}
