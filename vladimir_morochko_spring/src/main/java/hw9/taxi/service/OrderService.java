package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface OrderService {
    boolean createOrder(Client client, Integer amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, Integer amount, String addressFrom, String addressTo);

    List getOrders(Long orderAmountLowerLimit, Long orderAmountUpperLimit);
    List getOrdersByPortion(int portionSize);
}
