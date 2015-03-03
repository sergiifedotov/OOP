package hw8.taxi.action;

import hw8.taxi.exception.OrderException;
import hw8.taxi.service.OrderService;
import hw8.taxi.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private OrderService orderService;
    private Long id;
    private String amount;
    private String client;
//    private String client;

    @Override
    public void init() throws ServletException {
        orderService = new OrderServiceImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("order.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String client = request.getParameter("client");
        String addressFrom = request.getParameter("addressFrom");
        String addressTo = request.getParameter("addressTo");
        try {
            if (orderService.createOrder(id,client, this.amount,addressFrom,addressTo)) {
                request.setAttribute("message", "order created.");
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "you wrote something wrong, try again.");
                request.getRequestDispatcher("order.jsp").forward(request, response);
            }
        }   catch (OrderException e){
            e.printStackTrace();
        }
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}

