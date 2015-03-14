package hw9.taxi.service;

import hw9.taxi.dao.ClientDao;
import hw9.taxi.dao.OrderDao;
import hw9.taxi.domain.Client;
import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sanya on 12.03.2015.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ClientDao clientDao;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        Date date = null;
        try {
            date = dateFormat.parse(dateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Order order = new Order(date, client, Double.valueOf(amount),addressTo, addressFrom);
        client.setOrders(order);
        client.setDateLastOrder(date);
        client.setSumma(client.getSumma()+Double.valueOf(amount));
        clientDao.update(client);
        orderDao.create(order);
        return true;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
        Order order = (Order) read(id);

        order.setSumma(Double.valueOf(amount));
        order.setAddressFrom(addressFrom);
        order.setAddressTo(addressTo);

        Client oldClient = order.getClient();

        if (!oldClient.equals(client)) {
            oldClient.getOrders().remove(order);
            clientDao.update(oldClient);
            order.setClient(client);
            client.setOrders(order);
            clientDao.update(client);
        }

        update(order);
    }

    @Override
    public Object read(Long id) {
        return orderDao.read(id);
    }

    @Override
    public boolean update(Order order) {
        orderDao.update(order);
        return true;
    }

    @Override
    public boolean delete(Order order) {
        orderDao.delete(order);
        return true;
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public List<Order> findAllByPortion(int first, int result) {
        return orderDao.findAllByPortion(first, result);
    }

    @Override
    public List<Order> findAllDiapasonSumm(Double sumFrom, Double sumTo) {
        return orderDao.findAllDiapasonSumm(sumFrom, sumTo);
    }
}
