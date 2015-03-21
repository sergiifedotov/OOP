package hw9.taxi.service;

import hw9.taxi.dao.ClientDao;
import hw9.taxi.dao.OrderDao;
import hw9.taxi.domain.Client;
import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired(required = true)
    private OrderDao orderDao;

    @Autowired(required = true)
    private ClientDao clientDao;

    public OrderServiceImpl() {
    }

    @Override
    public Long createOrder(Long clientId, Integer amount, String addressFrom, String addressTo) throws OrderException {
        if (clientId == null) {
            throw new OrderException("Не выбран клиент");
        }

        // update client info
        Client client = clientDao.read(clientId);
        client.setSum(amount);
        client.setLastOrderDate(new Date());
        clientDao.update(client);

        // create order
        Order order = new Order(client, amount, addressFrom, addressTo);
        return orderDao.create(order);
    }

    @Override
    public void editOrder(Long orderId, Client client, Integer amount, String addressFrom, String addressTo) throws OrderException {
        if (client == null) {
            throw new OrderException("Не выбран клиент");
        }

        Order order = orderDao.read(orderId);

        order.setClient(client);
        order.setAmount(amount);
        order.setAddressFrom(addressFrom);
        order.setAddressTo(addressTo);
        orderDao.update(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List getOrders(Integer orderAmountLowerLimit, Integer orderAmountUpperLimit) {
        return orderDao.getOrders(orderAmountLowerLimit, orderAmountUpperLimit);
    }

    @Override
    @Transactional(readOnly = true)
    public List getOrdersByPortion(Integer portionSize) {
        return orderDao.getOrdersByPortion(portionSize);
    }

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        return orderDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrder(Long orderId) {
        return orderDao.read(orderId);
    }
}
