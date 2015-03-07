package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimir on 03.03.2015.
 *
 * Функции:
 - оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 - отредактировать заказ (поменять свойства заказа)
 - вывести список заказов на сумму в указанном диапазоне
 - вывести список всех заказов порциями по 5 штук

 session14.task1.taxi.service.OrderService
 boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException
 void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo)
 List showOrders(Long from, Long to)
 List showOrdersByPortion()
 */
public class OrderServiceImpl implements OrderService {

    public static OrderService orderService = new OrderServiceImpl();

    ClientService clientService = ClientServiceImpl.clientService;

    private ArrayList<Order> orders = new ArrayList<>();

    public OrderServiceImpl() {
        Client client = clientService.getClients().get(0);
        Long orderId = orders.size() + 1L;
        Order order = new Order(client, 123, "ул. Бассейная, 1", "ул. Бассейная, 2");
        order.setId(orderId);
        orders.add(order);
        client = clientService.getClients().get(1);
        orderId = orders.size() + 1L;
        order = new Order(client, 234, "ул. Бассейная, 2", "ул. Бассейная, 3");
        order.setId(orderId);
        orders.add(order);
        client = clientService.getClients().get(2);
        orderId = orders.size() + 1L;
        order = new Order(client, 345, "ул. Бассейная, 3", "ул. Бассейная, 4");
        order.setId(orderId);
        orders.add(order);
        client = clientService.getClients().get(3);
        orderId = orders.size() + 1L;
        order = new Order(client, 456, "ул. Бассейная, 4", "ул. Бассейная, 5");
        order.setId(orderId);
        orders.add(order);
        client = clientService.getClients().get(4);
        orderId = orders.size() + 1L;
        order = new Order(client, 567, "ул. Бассейная, 5", "ул. Бассейная, 6");
        order.setId(orderId);
        orders.add(order);
        client = clientService.getClients().get(5);
        orderId = orders.size() + 1L;
        order = new Order(client, 678, "ул. Бассейная, 6", "ул. Бассейная, 1");
        order.setId(orderId);
        orders.add(order);
    }

    public OrderServiceImpl(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean createOrder(Client client, Integer amount, String addressFrom, String addressTo) throws OrderException {
        if (client != null) {
            Long id = orders.size() + 1L;
            Order order = new Order(id, client, amount, addressFrom, addressTo);
            return orders.add(order);
        } else {
            throw new OrderException();
        }
    }

    @Override
    public void editOrder(Long id, Client client, Integer amount, String addressFrom, String addressTo) {
        for (Order order : orders) {
            if (order.getId() == id) {
                order.setClient(client);
                order.setAmount(amount);
                order.setAddressFrom(addressFrom);
                order.setAddressTo(addressTo);
                break;
            }
        }
    }

    @Override
    public List showOrders(Integer orderAmountLowerLimit, Integer orderAmountUpperLimit) {
        List<Order> list = new ArrayList<>();
        for (Order order : orders) {
            Integer amount = order.getAmount();
            if (amount >= orderAmountLowerLimit && amount <= orderAmountUpperLimit) {
                list.add(order);
            }
        }
        return list;
    }

    @Override
    public List showOrdersByPortion(int portionSize) {
        int orderPortionSize = portionSize > orders.size() ? orders.size() : portionSize;
        return orders.subList(0, orderPortionSize);
    }

    @Override
    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public Order getOrderById(Long id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

}
