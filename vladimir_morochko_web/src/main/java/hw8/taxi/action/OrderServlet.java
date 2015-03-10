package hw8.taxi.action;

import hw8.taxi.service.*;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by vladimir on 03.03.2015.
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    OrderService orderService = OrderServiceImpl.orderService;
    ClientService clientService = ClientServiceImpl.clientService;
    PropertiesService propertiesService = PropertiesServiceImpl.propertiesService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List list = null;
        if (action.equals("createOrder")) {
            request.setAttribute("orderMessage", "createOrder");
            request.getSession().setAttribute("defaultClientId", 1L);
            request.setAttribute("defaultAmount", 0);
            request.getRequestDispatcher("order.jsp").forward(request, response);
        }
        if (action.equals("editOrder")) {
            Long orderId = Long.parseLong(request.getParameter("orderId"));
            Order order = orderService.getOrderById(orderId);
            request.setAttribute("orderMessage", "editOrder");
            request.getSession().setAttribute("defaultClientId", order.getClient().getId());
            request.setAttribute("defaultAmount", order.getAmount());
            request.setAttribute("defaultAddressFrom", order.getAddressFrom());
            request.setAttribute("defaultAddressTo", order.getAddressTo());

            Long nextOrderId = (orderId + 1) > orderService.getOrders().size() ?
                    orderService.getOrders().size() :
                    (orderId + 1);
            request.setAttribute("nextOrderId", nextOrderId);
            Long prevOrderId = (orderId - 1) < 1 ? 1 : (orderId - 1);
            request.setAttribute("prevOrderId", prevOrderId);
            request.getRequestDispatcher("order.jsp").forward(request, response);
        }
        if (action.equals("saveOrder")) {
            Long clientId = Long.parseLong(request.getParameter("clientChoice"));
            Client client = clientService.getClientById(clientId);
            String stringAmount = request.getParameter("amount");
            Integer amount = 0;
            if (!stringAmount.equals("")) {
                amount = Integer.parseInt(stringAmount);
            }
            // update client info
            client.setSum(client.getSum() + amount);
            client.setLastOrderDate(new Date());

            String addressFrom = request.getParameter("addressFrom");
            String addressTo = request.getParameter("addressTo");

            boolean registerResult = false;
            try {
                registerResult = orderService.createOrder(client, amount, addressFrom, addressTo);
            } catch (OrderException e) {
                e.printStackTrace();
            }
            String orderMessage = registerResult ? "Order created successfully" : "Error!";
            request.setAttribute("orderMessage", orderMessage);
            request.getRequestDispatcher("order.jsp").forward(request, response);
        }
        if (action.equals("showOrders")) {
            int lowerLimit = Integer.parseInt(request.getParameter("lowerLimit"));
            int upperLimit = Integer.parseInt(request.getParameter("upperLimit"));
            list = orderService.showOrders(lowerLimit, upperLimit);
            request.setAttribute("lowerLimit", lowerLimit);
            request.setAttribute("upperLimit", upperLimit);
            request.getSession().setAttribute("orderList", list);
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        }
        if (action.equals("showOrdersByPortion")) {
            int portionSize = propertiesService.getOrderPortionSize();
            list = orderService.showOrdersByPortion(portionSize);
            request.setAttribute("lowerLimit", 0);
            request.setAttribute("upperLimit", 10000);
            request.getSession().setAttribute("orderList", list);
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        }
    }
}
