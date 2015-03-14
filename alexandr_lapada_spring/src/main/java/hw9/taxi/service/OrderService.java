package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by sanya on 12.03.2015.
 */
public interface OrderService {

    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;

    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);

    Object read(Long id);

    boolean update(Order order);

    boolean delete(Order order);

    List<Order> findAll();

    List<Order> findAllByPortion(int first, int result);

    List<Order> findAllDiapasonSumm(Double sumFrom, Double sumTo);

}
