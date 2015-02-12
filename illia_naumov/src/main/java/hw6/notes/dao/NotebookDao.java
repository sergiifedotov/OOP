package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by iilia_naumov
 * <p/>
 * Создать DAO для таблицы ноутбуки
 * Таблица ноутбуки имеет следующую структуру
 * (id, serial, vendor, model, manufacture date, price)
 * domain
 * hw6.notes.domain.Notebook
 * dao
 * hw6.notes.dao.NotebookDao
 * Long create(Notebook ntb)
 * Notebook read(Long ig)
 * boolean update(Notebook ntb)
 * boolean delete(Notebook ntb)
 * List<Notebook> findAll()
 * hw6.notes.dao.NotebookDaoImpl
 */
public interface NotebookDao {

    Long create(Notebook ntb);
    Notebook read(Long ig);
    boolean update(Notebook ntb);
    boolean delete(Notebook ntb);
    List<Notebook> findAll();
    List<Notebook> findByModel(String model);
    List<Notebook> findByVendor(String vendor);
    List<Notebook> findByPriceManufDate(Double price, Date date);
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, /**Date date,*/ String vendor);

}
