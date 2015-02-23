package hw7.notes.dao;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by @CAT_Caterpiller on 10.02.2015.
 */


/*
     Long create(Notebook ntb)
     Notebook read(Long ig)
     boolean update(Notebook ntb)
     boolean delete(Notebook ntb)
     List<Notebook> findAll()
*/


public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List<Notebook> findAll();
    List<Notebook> findByModel(String model);
    List<Notebook> findByVendor(String vendor);
    List<Notebook> findByPriceManufDate(Double price, Date date);
    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);

    public void close();

    
}
