package hw6.notes.service;


import hw6.notes.dao.NotebookDao;
import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Написать приложение для управления ноутбуками.
 Реализовать функции:
 - Добавить новый ноутбук
 - Показать список ноутбуков (включая порядковый номер id)

 domain
 hw6.notes.domain.Notebook
 dao
 hw6.notes.dao.NotebookDao
 Long create(Notebook notebook)
 Notebook read(Long ig)
 boolean update(Notebook notebook)
 boolean delete(Notebook notebook)
 List<Notebook> findAll()
 hw6.notes.dao.NotebookDaoImpl
 util
 hw6.notes.util.HibernateUtil
 service
 hw6.notes.service.NotebookService
 Long add(Notebook notebook)
 List<Notebook> findAll()
 hw6.notes.service.NotebookServiceImpl
 view
 hw6.notes.service.Menu
 main()
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao;

    public NotebookServiceImpl(NotebookDao dao) {
        notebookDao = dao;
    }

    public NotebookServiceImpl() {
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
