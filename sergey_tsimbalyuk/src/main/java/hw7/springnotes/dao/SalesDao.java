package hw7.springnotes.dao;

import hw7.notes.domain.Sales;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
public interface SalesDao {
    Long create(Sales store);
    Sales read(Long id);
    boolean update(Sales store);
    boolean delete(Sales store);
    List<Sales> findAll();
}
