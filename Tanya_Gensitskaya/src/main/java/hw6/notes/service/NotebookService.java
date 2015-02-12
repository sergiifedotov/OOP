package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 Написать приложение для управления ноутбуками.
 Реализовать функции:
 - Добавить новый ноутбук
 - Показать список ноутбуков (включая порядковый номер id)

 dao
        hw6.notes.dao.NotebookDao
        hw6.notes.dao.NotebookDaoImpl

        Long create(Notebook notebook)
        Notebook read(Long ig)
        boolean update(Notebook notebook)
        boolean delete(Notebook notebook)
        List<Notebook> findAll()
 domain
         hw6.notes.domain.Notebook


 util
        hw6.notes.util.HibernateUtil
 service
        hw6.notes.service.NotebookService
        hw6.notes.service.NotebookServiceImpl

        Long add(Notebook notebook)
        List<Notebook> findAll()

 view
        hw6.notes.service.Menu
        main()
 */
public interface NotebookService {
    Long add(Notebook notebook);
    List<Notebook> findAll();
    Notebook read(Long id);
    void deleteNtb(Notebook notebook);
    void changePrice(Long id, double price);
    void changeSerialVendor(Long id, String serial, String vendor);
}
