package hw9.taxi.controller;

import hw9.taxi.domain.Order;
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
@WebServlet("/ShowPortionOrder")
public class OrderShowPortionServlet extends HttpServlet {

    private WebApplicationContext context;
    private OrderServiceImpl orderService;
    private static int a;
    private final int porcia = 5;

    @Override
    public void init(){
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        orderService = (OrderServiceImpl) context.getBean("orderServiceImpl");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("action"));
        ArrayList<Order> list = (ArrayList<Order>) orderService.findAll();

        if (request.getParameter("action").equals("Show all orders by porcia")
                || request.getParameter("action").equals("right")
                || request.getParameter("action").equals("left")) {

            ArrayList<Order> listPorcia = null;

            if (request.getParameter("action").equals("Show all orders by porcia")) {
                listPorcia = (ArrayList<Order>) orderService.findAllByPortion(a * porcia, porcia);
            }

            if (request.getParameter("action").equals("right")) {
                if (a * porcia < list.size()) {
                    listPorcia = (ArrayList<Order>) orderService.findAllByPortion(a * porcia, porcia);
                    a++;
                } else {
                    a = 0;
                    listPorcia = (ArrayList<Order>) orderService.findAllByPortion(a * porcia, porcia);
                    a++;
                }
            }

            if (request.getParameter("action").equals("left")) {
                if (a == 0) {
                    listPorcia = (ArrayList<Order>) orderService.findAllByPortion(a * porcia, porcia);
                    a = list.size() / porcia;
                    a--;
                } else {

                    listPorcia = (ArrayList<Order>) orderService.findAllByPortion(a * porcia, porcia);
                    a--;
                }

            }
            System.out.println(a);
            //request.setAttribute("login", list);
            request.setAttribute("viewAllOrdersByPorcia", listPorcia);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }

    }
}
