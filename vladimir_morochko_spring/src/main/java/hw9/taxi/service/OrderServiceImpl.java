package hw9.taxi.service;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
public class OrderServiceImpl implements OrderService {
//    @Override
//    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
//        return false;
//    }
//
//    @Override
//    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
//
//    }

    @Override
    public boolean createOrder(Long id, String client, String amount, String addressFrom, String addressTo) throws OrderException {
        return false;
    }

    @Override
    public void editOrder(Long id, String client, String amount, String addressFrom, String addressTo) {

    }

    @Override
    public List showOrders(Long orderAmountLowerLimit, Long orderAmountUpperLimit) {
        return null;
    }

    @Override
    public List showOrdersByPortion(int portionSize) {
        return null;
    }

    @Override
    public List sowOrdersByPortion() {
        return null;
    }
}
