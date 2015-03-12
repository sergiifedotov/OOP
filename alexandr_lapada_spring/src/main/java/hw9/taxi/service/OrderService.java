package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

/**
 * Created by sanya on 12.03.2015.
 */
public interface OrderService {

    boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException;

    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);


}
