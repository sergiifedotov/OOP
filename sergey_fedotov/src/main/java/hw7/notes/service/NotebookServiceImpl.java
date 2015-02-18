package hw7.notes.service;


import hw7.notes.dao.NotebookDao;
import hw7.notes.domain.Notebook;

import java.util.List;

/**
 *
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao;

    public NotebookServiceImpl(NotebookDao dao) {
        notebookDao = dao;
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDao.findAll();
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }
}
