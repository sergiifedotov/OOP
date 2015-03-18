package hw9.taxi.service;

import hw9.taxi.dao.OrderDao;
import hw9.taxi.domain.Client;
import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired(required = true)
    private OrderDao orderDao;

    public OrderServiceImpl() {
    }

    public OrderServiceImpl(OrderDao dao) {
        orderDao = dao;
    }


    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        Date tempDate = GregorianCalendar.getInstance().getTime();
        orderDao.create(new Order(tempDate,client,Integer.parseInt(amount),addressFrom,addressTo));
        return false;
    }


    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
        Order order = orderDao.read(id);
        order.setClient(client);
        order.setAmount(Integer.parseInt(amount));
        order.setAddressTo(addressTo);
        order.setAddressFrom(addressFrom);
        orderDao.update(order);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getOrdersByPortion(int portionSize) {
        return orderDao.getOrdersByPortion(portionSize);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getOrdersGtSum(int sum) {
        return orderDao.getOrdersGtSum(sum);
    }

}
