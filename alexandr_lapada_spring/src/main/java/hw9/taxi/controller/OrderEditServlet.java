package hw9.taxi.controller;

import hw9.taxi.domain.Client;
import hw9.taxi.domain.Order;
import hw9.taxi.service.ClientServiceImpl;
import hw9.taxi.service.OrderServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sanya on 12.03.2015.
 */
@WebServlet("/EditOrder")
public class OrderEditServlet extends HttpServlet {

    private WebApplicationContext context;
    private ClientServiceImpl clientService;
    private OrderServiceImpl orderService;

    @Override
    public void init(){
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        clientService = (ClientServiceImpl) context.getBean("clientServiceImpl");
        orderService = (OrderServiceImpl) context.getBean("orderServiceImpl");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Client> listClients = (ArrayList<Client>) clientService.findAll();
        ArrayList<Order> listOrders = (ArrayList<Order>) orderService.findAll();

        if (request.getParameter("action").equals("Edit order")){

            request.setAttribute("listOrders", listOrders);
            request.getRequestDispatcher("orderEdit.jsp").forward(request, response);
        }

    }
}
