package hw9.taxi.service;

import hw9.taxi.controller.OrderException;
import hw9.taxi.domain.Client;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
public interface OrderService {
    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);
}
