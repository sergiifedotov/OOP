package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
public class OrderServiceImpl implements OrderService {

    private Map<Long,Order> orders = new HashMap<>();


    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {

        Order order = new Order(new java.util.Date(),client, Integer.getInteger(amount), addressFrom, addressTo);
        orders.put(id,order);
        return true;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
        Order order = orders.get(id);
        if (order!=null){
            order.setClient(client);
            order.setAmount(Integer.getInteger(amount));
            order.setAddressFrom(addressFrom);
            order.setAddressTo(addressTo);
        }

    }

    @Override
    public List showOrders(Long from, Long to) {
        return (List) orders.values();
    }

    @Override
    public List showOrdersByPortion() {
        return (List) orders.values();
    }
}
