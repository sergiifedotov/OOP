package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

/**
 * Created by vladimir on 09.03.2015.
 */
public interface OrderService {
    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);

    boolean createOrder(Long id, String client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, String client, String amount, String addressFrom, String addressTo);
}
