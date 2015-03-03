package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.OrderException;

import java.util.List;

/**
 * Created by vladimir on 03.03.2015.
 *
 * Функции:
 - оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 - отредактировать заказ (поменять свойства заказа)
 - вывести список заказов на сумму в указанном диапазоне
 - вывести список всех заказов порциями по 5 штук

 hw8.taxi.service.OrderService
 boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException
 void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo)
 List showOrders(Long from, Long to)
 List showOrdersByPortion()
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
    public List showOrders(Long from, Long to) {
        return null;
    }

    @Override
    public List showOrdersByPortion() {
        return null;
    }

    @Override
    public boolean createOrder(Long id, String client, String amount, String addressFrom, String addressTo) throws OrderException {
        return false;
    }

    @Override
    public void editOrder(Long id, String client, String amount, String addressFrom, String addressTo) {

    }
}
