package hw9.taxi.controller;

import hw9.taxi.service.OrderService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by vladimir on 09.03.2015.
 */
@WebServlet("/orderShowServlet")
public class OrderShowServlet extends HttpServlet {

    private OrderService orderService;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        orderService = webApplicationContext.getBean("orderServiceImpl", OrderService.class);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer lowerLimit = 0;
        Integer upperLimit = 1000;
        try {
            lowerLimit = Integer.parseInt(request.getParameter("orderAmountLowerLimit"));
            upperLimit = Integer.parseInt(request.getParameter("orderAmountUpperLimit"));
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        List list = orderService.getOrders(lowerLimit, upperLimit);
        request.getSession().setAttribute("orderList", list);
        request.setAttribute("orderMessage", "Заказы на сумму от " + lowerLimit + " до " + upperLimit + ":");
        request.getRequestDispatcher("orders.jsp").forward(request, response);

    }
}
