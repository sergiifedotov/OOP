package hw9.taxi.dao;


import hw9.taxi.domain.Order;

import java.util.List;

/**
 */
public interface OrderDao {

    Long create(Order order);
    Order read(Long id);
    boolean update(Order order);

    List<Order> getOrdersByPortion(int portionSize);
    List<Order> getOrdersGtSum(int sum);

}
