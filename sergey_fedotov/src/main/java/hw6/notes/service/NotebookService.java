package hw6.notes.service;

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
public interface NotebookService {
 Long add(Notebook notebook);
 List<Notebook> findAll();

 void changePrice(Long id, double price);
 void changeSerialVendor(Long id, String serial, String vendor);
 boolean delete(Long id);

 boolean deleteByModel(String model);
 List<Notebook> findByVendor(String vendor);
 List<Notebook> findByPriceManufDate(Double price, Date date);
 List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
}
