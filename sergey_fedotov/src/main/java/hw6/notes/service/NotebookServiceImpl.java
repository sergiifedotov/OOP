package hw6.notes.service;


import hw6.notes.dao.NotebookDao;
import hw6.notes.domain.Notebook;

import java.util.Date;
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

 Добавить в приложение ноутбуков следующие функции:
 - Удалить ноутбуки по названию модели
 - Получить ноутбуки по производителю
 - Получить ноутбуки по цене и году выпуска
 - Получить ноутбуки по цене в указанном диапазоне, меньше указанной даты выпуска и указанного производителя

 domain
 hw6.notes.domain.Notebook
 dao
 hw6.notes.dao.NotebookDao
 List<Notebook> findByModel(String model)
 List<Notebook> findByVendor(String vendor)
 List<Notebook> findByPriceManufDate(Double price, Date date)
 List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor)
 hw6.notes.dao.NotebookDaoImpl
 util
 hw6.notes.util.HibernateUtil
 service
 hw6.notes.service.NotebookService
 boolean deleteByModel(String model)
 List<Notebook> findByVendor(String vendor)
 List<Notebook> findByPriceManufDate(Double price, Date date)
 List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor)
 hw6.notes.service.NotebookServiceImpl
 view
 hw6.notes.service.Menu
 main()
 void deleteByModel()
 void showByVendor()
 void showByPriceManufDate()
 void showBetweenPriceLtDateByVendor()
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
    public void changePrice(Long id, double price) {
        Notebook notebook = notebookDao.read(id);
        notebook.setPrice(price);
        notebookDao.update(notebook);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook notebook = notebookDao.read(id);
        notebook.setSerial(serial);
        notebook.setVendor(vendor);
        notebookDao.update(notebook);
    }

    @Override
    public boolean delete(Long id) {
        Notebook notebook = notebookDao.read(id);
        return notebookDao.delete(notebook);
    }

    @Override
    public boolean deleteByModel(String model) {

        List<Notebook> list = notebookDao.findByModel(model);

        if (list != null && list.size() > 0) {
            for (Notebook notebook : list) {
                notebookDao.delete(notebook);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return notebookDao.findByVendor(vendor);
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return notebookDao.findByPriceManufDate(price,date);
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return notebookDao.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }

}
