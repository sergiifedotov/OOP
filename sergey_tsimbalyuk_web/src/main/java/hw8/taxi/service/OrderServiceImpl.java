package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
public class OrderServiceImpl implements OrderService{

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        return false;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {

    }

    @Override
    public List showOrders(Long from, Long to) {
        return null;
    }

    @Override
    public List showOrdersByPortion() {
        return null;
    }
}
