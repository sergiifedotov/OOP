package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

/**
 * Created by vladimir on 09.03.2015.
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        return false;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {

    }
}
