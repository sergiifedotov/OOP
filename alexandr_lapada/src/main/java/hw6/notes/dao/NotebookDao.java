package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by sanya on 10.02.2015.
 */
public interface NotebookDao {
    Long create(Notebook ntb);

    Notebook read(Long id);

    boolean update(Notebook ntb);

    boolean delete(Notebook ntb);

    List<Notebook> findAll();

    List<Notebook> findByModel(String model);

    List<Notebook> findByVendor(String vendor);

    List<Notebook> findByPriceManufDate(Double price, Date date);

    List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
}
