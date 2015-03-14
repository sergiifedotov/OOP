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
@WebServlet("/orderShowPortionServlet")
public class OrderShowPortionServlet extends HttpServlet {

    private OrderService orderService;
    private Integer orderPortionSize;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        orderService = webApplicationContext.getBean("orderServiceImpl", OrderService.class);
        orderPortionSize = webApplicationContext.getBean("orderPortionSize", Integer.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List list = orderService.getOrdersByPortion(orderPortionSize);
        request.setAttribute("orderMessage", "Заказы по " + orderPortionSize + " штук:");
        request.getSession().setAttribute("orderList", list);
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }
}
