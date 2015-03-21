package hw9.taxi.controller;

import hw9.taxi.dao.ClientDao;
import hw9.taxi.dao.OrderDao;
import hw9.taxi.domain.Client;
import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;
import hw9.taxi.service.ClientService;
import hw9.taxi.service.OrderService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by vladimir on 09.03.2015.
 */
@WebServlet("/orderEditServlet")
public class OrderEditServlet extends HttpServlet {

    private OrderService orderService;
    private ClientService clientService;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        orderService = webApplicationContext.getBean("orderServiceImpl", OrderService.class);
        clientService = webApplicationContext.getBean("clientServiceImpl", ClientService.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("action=" + action);
        String orderMessage = null;
        String addressFrom = request.getParameter("addressFrom");
        String addressTo = request.getParameter("addressTo");
        Long orderId = 0L;
        try {
            orderId = Long.parseLong(request.getParameter("orderId"));
        } catch (NumberFormatException ignored) {
        }
        if (action != null && action.equals("saveOrder")) {
            Long clientId = 0L;
            try {
                clientId = Long.parseLong(request.getParameter("clientChoice"));
            } catch (NumberFormatException ignored) {
            }
            Integer amount = 0;
            try {
                amount = Integer.parseInt(request.getParameter("amount"));
            } catch (NumberFormatException ignored) {
            }
            Client client = clientService.getClient(clientId);

            try {
                orderService.editOrder(orderId, client, amount, addressFrom, addressTo);
                request.setAttribute("dashboardMessage", "Заказ успешно отредактирован");
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } catch (OrderException e) {
                //e.printStackTrace();
                orderMessage = e.getMessage();
            }
        }
        if (action != null && action.equals("editOrder")) {
            List list = orderService.findAll();
            request.getSession().setAttribute("orderList", list);
            request.setAttribute("orderMessage", "Выберте интересующий вас заказ");
            request.getSession().setAttribute("action", "editOrder");
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        }
        List list = clientService.findAll();
        Order order = orderService.getOrder(orderId);
        System.out.println(order);
        request.getSession().setAttribute("clientList", list);
        request.getSession().setAttribute("defaultClientId", order.getClient().getId());
        request.setAttribute("defaultAmount", order.getAmount());
        request.setAttribute("orderId", orderId);
        request.setAttribute("defaultAddressFrom", order.getAddressFrom());
        request.setAttribute("defaultAddressTo", order.getAddressTo());
        request.setAttribute("orderMessage", orderMessage);
        request.getRequestDispatcher("editOrder.jsp").forward(request, response);
    }
}
