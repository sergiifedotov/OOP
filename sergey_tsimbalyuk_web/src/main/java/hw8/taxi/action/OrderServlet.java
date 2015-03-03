package hw8.taxi.action;

import hw8.taxi.domain.Client;
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
    private Client client;

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

    public void setClient(Client client) {
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

/*
package hw8.taxi.action;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.ClientException;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.ClientServiceImpl;
import hw8.taxi.service.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private RequestDispatcher disp;
    private OrderServiceImpl orderService;
    private ArrayList<Client> clients;
    private ArrayList<Order> orders;
    private ArrayList<Order> reportOrders;
    private Integer portion;

    public void init(){
        this.orderService = new OrderServiceImpl();
        this.portion = 0;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        //берем из сессии информацию о зарегистрированных клиентах
        try {
            HttpSession session = request.getSession();
            this.clients = (ArrayList)session
                    .getAttribute("clients");
            if(this.clients == null){
                this.orderService = new OrderServiceImpl();
            } else {
                this.orderService = new OrderServiceImpl(this.clients);
            }
        } catch (Exception e){
            this.orderService = new OrderServiceImpl();
        }
        //берем из сессии информацию о существующих заказах
        try{
            HttpSession session = request.getSession();
            this.orders = (ArrayList)session
                    .getAttribute("orders");
            if(this.orders != null) {
                this.orderService = new OrderServiceImpl(this.orders, this.clients);
            }
        }catch (Exception e){
            this.orderService = new OrderServiceImpl();
        }
        //берем из сессии информацию о выводимой порции клиентов
        try {
            HttpSession session = request.getSession();
            this.portion = (Integer)session
                    .getAttribute("portionOrders");
            if(this.portion == null){
                this.portion = 0;
            }
        } catch (Exception e){
            this.portion = 0;
        }
        //обработка отчетов по заказах
        if (parameterMap.containsKey("reportOrders")){
            this.reportOrders = null;
            String reportSelection = parameterMap.get("reportOrders")[0];
            if(reportSelection.equals("showOrdersByPortion")){
                this.portion += 5;
                this.reportOrders = (ArrayList)this.orderService.showOrdersByPortion(this.portion);
                request.setAttribute("title", "All orders");
                request.getSession().setAttribute("reportSelection", "All orders");
                request.getSession().setAttribute("reportsOrder", this.reportOrders);
                request.getSession().setAttribute("portionOrders", this.portion);
                disp = request.getRequestDispatcher("orders.jsp");
                disp.forward(request, response);

            }
            if(reportSelection.equals("showOrders")){
                Long fromAmount = Long.parseLong(parameterMap.get("from")[0]);
                Long toAmount = Long.parseLong(parameterMap.get("to")[0]);
                this.reportOrders = (ArrayList) this.orderService.showOrders(fromAmount,
                        toAmount);
                request.setAttribute("title", "List of orders for amount in the range from " + fromAmount
                        + " to " + toAmount);
                request.getSession().setAttribute("reportSelection", "List of orders for amount in the range from "
                        + fromAmount + " to " + toAmount);
                request.getSession().setAttribute("reportsOrder", this.reportOrders);
                disp = request.getRequestDispatcher("orders.jsp");
                disp.forward(request, response);
            }
        }
        //регистрация или изменение заказа
        if (parameterMap.containsKey("selectClient")){
            Long clientId = Long.parseLong(parameterMap.get("selectClient")[0]);
            Client client = null;
            for (Client currentClient : clients){
                if(currentClient.getId() == clientId){
                    client = currentClient;
                }
            }
            String amount = parameterMap.get("orderAmount")[0];
            String addressFrom = parameterMap.get("addressFrom")[0];
            String addressTo = parameterMap.get("addressTo")[0];
            if (parameterMap.containsKey("newId")){
                Long id = Long.parseLong(parameterMap.get("newId")[0]);
                try{
                    if (this.orderService.createOrder(id, client, amount, addressFrom, addressTo)){
                        orders = (ArrayList)orderService.getOrders();
                        String message = "Order id=" + id + " , for the client "
                                + client.getName() + " " + client.getSurname()
                                + " cost " + amount
                                + " from address " + addressFrom
                                + " to address " + addressTo
                                + " successfully registered";
                        request.setAttribute("successful", message);
                        disp = request.getRequestDispatcher("dashboard.jsp");
                        request.getSession().setAttribute("orders", this.orderService.getOrders());
                        disp.forward(request, response);
                    }
                } catch (OrderException e){
                    String message = e.getMessage();
                    request.setAttribute("error", message);
                    disp = request.getRequestDispatcher("order.jsp");
                    disp.forward(request, response);
                }
            }
            if (parameterMap.containsKey("correctId")){
                Long id = Long.parseLong(parameterMap.get("correctId")[0]);
                this.orderService.editOrder(id, client, amount, addressFrom, addressTo);
                String message =  "Order id=" + id + " , for the client "
                        + client.getName() + " " + client.getSurname()
                        + " cost " + amount
                        + " from address " + addressFrom
                        + " to address " + addressTo
                        + " successfully registered";
                request.setAttribute("successful", message);
                disp = request.getRequestDispatcher("dashboard.jsp");
                request.getSession().setAttribute("orders", this.orderService.getOrders());
                disp.forward(request, response);
            }
        }
        if (parameterMap.containsKey("submit")){
            this.portion += 5;
            this.reportOrders = (ArrayList)this.orderService.showOrdersByPortion(this.portion);
            request.setAttribute("title", "All orders");
            request.getSession().setAttribute("reportsOrder", this.reportOrders);
            request.getSession().setAttribute("portionOrders", this.portion);
            disp = request.getRequestDispatcher("orders.jsp");
            disp.forward(request, response);
        }
        if(parameterMap.containsKey("id")){
            String idCorrectOrder = parameterMap.get("id")[0];
            request.getSession().setAttribute("idCorrectOrder", idCorrectOrder);
            disp = request.getRequestDispatcher("order.jsp");
            disp.forward(request, response);
        }

    }

    public void doGet(HttpServletRequest request,HttpServletResponse response){

    }

}*/
