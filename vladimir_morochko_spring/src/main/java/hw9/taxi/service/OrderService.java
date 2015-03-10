package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface OrderService {
    //boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    //void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);

    boolean createOrder(Long id, String client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, String client, String amount, String addressFrom, String addressTo);

    List showOrders(Long orderAmountLowerLimit, Long orderAmountUpperLimit);
    List showOrdersByPortion(int portionSize);
    List sowOrdersByPortion(); // WTF?
}
