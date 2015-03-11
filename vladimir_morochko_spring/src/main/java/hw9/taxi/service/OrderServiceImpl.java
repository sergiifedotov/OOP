package hw9.taxi.service;

import hw9.taxi.dao.OrderDao;
import hw9.taxi.domain.Client;
import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vladimir on 09.03.2015.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired(required = true)
    private OrderDao orderDao;

    public OrderServiceImpl() {
    }

    @Override
    public boolean createOrder(Client client, Integer amount, String addressFrom, String addressTo) throws OrderException {
        if (client != null) {
            Order order = new Order(client, amount, addressFrom, addressTo);
            Long id = orderDao.create(order);
            return true;
        } else {
            throw new OrderException("не выбран клиент");
        }
    }

    @Override
    public void editOrder(Long id, Client client, Integer amount, String addressFrom, String addressTo) {

    }

    @Override
    public List getOrders(Long orderAmountLowerLimit, Long orderAmountUpperLimit) {
        return null;
    }

    @Override
    public List getOrdersByPortion(int portionSize) {
        return null;
    }
}
