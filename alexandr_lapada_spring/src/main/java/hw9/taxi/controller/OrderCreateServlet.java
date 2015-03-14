package hw9.taxi.controller;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sanya on 12.03.2015.
 */
@WebServlet("/CreateOrder")
public class OrderCreateServlet extends HttpServlet {

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

        if (request.getParameter("action").equals("Create order")){
            request.setAttribute("listClients", listClients);
            request.getRequestDispatcher("order.jsp").forward(request, response);
        }

        if (request.getParameter("action").equals("Ok")) {
            Client client = clientService.read(Long.valueOf(request.getParameter("option")));
            if (validTestSumma(request.getParameter("summaOrder"))) {
                try {
                    orderService.createOrder(null, client, request.getParameter("summaOrder"), request.getParameter("addressFrom"), request.getParameter("addressTo"));
                } catch (OrderException e) {
                    e.printStackTrace();
                }
                request.setAttribute("successful", "Create order successful");
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else{
                request.setAttribute("wrongSumma","Wrong summa");
                request.setAttribute("listClients", listClients);
                request.getRequestDispatcher("order.jsp").forward(request, response);
            }
        }

        if (request.getParameter("action").equals("Cancel")){
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }
    }
    public boolean validTestSumma(String summa){
        if (summa != null) {
            Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*.).{1,}$");
            Matcher m = p.matcher(summa);
            return m.matches();
        }
        return false;
    }
}
