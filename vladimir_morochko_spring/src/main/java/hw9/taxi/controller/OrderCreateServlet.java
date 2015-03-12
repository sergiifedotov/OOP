package hw9.taxi.controller;

import hw9.taxi.dao.ClientDao;
import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;
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
@WebServlet("/orderCreateServlet")
public class OrderCreateServlet extends HttpServlet {

    private ClientDao clientDao;
    private OrderService orderService;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        orderService = webApplicationContext.getBean("orderServiceImpl", OrderService.class);
        clientDao = webApplicationContext.getBean("clientDaoImpl", ClientDao.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setAttribute("action", null);
        String orderMessage = null;
        Long clientId = 1L;
        Integer amount = 0;
        try {
            clientId = Long.parseLong(request.getParameter("clientChoice"));
            amount = Integer.parseInt(request.getParameter("amount"));
        } catch (NumberFormatException ignored) {
        }

        if (action != null && action.equals("saveOrder")) {
            Client client = clientDao.read(clientId);

            // update client info
            client.setSum(amount);
            client.setLastOrderDate(new Date());
            clientDao.update(client);

            String addressFrom = request.getParameter("addressFrom");
            String addressTo = request.getParameter("addressTo");
            Long orderId;
            try {
                orderId = orderService.createOrder(client, amount, addressFrom, addressTo);
                orderMessage = "создан заказ с id=" + orderId;
            } catch (OrderException e) {
                orderMessage = e.getMessage();
            }
        }

        List list = clientDao.findAll();
        request.getSession().setAttribute("clientList", list);
        request.getSession().setAttribute("defaultClientId", clientId);
        request.setAttribute("defaultAmount", 0);
        request.setAttribute("orderMessage", orderMessage);
        request.getRequestDispatcher("createOrder.jsp").forward(request, response);
    }
}
