package hw9.taxi.dao;

import hw9.taxi.domain.Order;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface OrderDao {
    Long create(Order order);
    Order read(Long id);
    boolean update(Order order);
    boolean delete(Order order);
    List findAll();
}
