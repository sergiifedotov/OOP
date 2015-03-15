package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;

import java.util.List;

/**
 *
 */
public interface OrderService {

    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;

    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);

    List<Order> getOrdersByPortion(int portionSize);
    List<Order> getOrdersGtSum(int sum);

}
