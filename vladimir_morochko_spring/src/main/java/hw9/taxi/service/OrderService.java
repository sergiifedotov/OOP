package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface OrderService {
    Long createOrder(Long clientId, Integer amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long orderId, Client client, Integer amount, String addressFrom, String addressTo) throws OrderException;

    List getOrders(Integer orderAmountLowerLimit, Integer orderAmountUpperLimit);
    List getOrdersByPortion(Integer portionSize);

    List findAll();
    Order getOrder(Long orderId);
}
