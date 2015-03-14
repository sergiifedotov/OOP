package hw9.taxi.dao;

import hw9.taxi.domain.Order;

import java.util.List;

/**
 * Created by sanya on 12.03.2015.
 */
public interface OrderDao {
    Long create(Order order);

    Object read(Long id);

    boolean update(Order order);

    boolean delete(Order order);

    List<Order> findAll();

    List<Order> findAllByPortion(int first, int result);

    List<Order> findAllDiapasonSumm(Double sumFrom, Double sumTo);
}
