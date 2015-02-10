package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by @CAT_Caterpiller on 11.02.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDaoImpl notebookDao;

    public NotebookServiceImpl() {}

    public NotebookServiceImpl(NotebookDaoImpl notebookDao) {
        super();
        this.notebookDao = notebookDao;
    }

    @Override
    public Long add(Notebook notebook) {
        if (notebook != null) {
            Long id = (Long) notebookDao.create(notebook);
            return id;
        } else return null;
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDao.findAll();
    }
}
