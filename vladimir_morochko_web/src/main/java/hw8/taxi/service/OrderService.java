package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimir on 03.03.2015.
 */
public interface OrderService {
    boolean createOrder(Client client, Integer amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, Integer amount, String addressFrom, String addressTo);
    List showOrders(Integer from, Integer to);
    List showOrdersByPortion(int portionSize);

    ArrayList<Order> getOrders();
    void setOrders(ArrayList<Order> orders);
    Order getOrderById(Long id);
}
