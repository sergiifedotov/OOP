package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
public interface OrderService {
    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);
    List showOrders(Long from, Long to);
    List showOrdersByPortion();

//    boolean createOrder(String id, String client, String amount, String fromAddress, String toAddress);
}
