package hw9.taxi.controller;

import hw9.taxi.domain.Client;
import hw9.taxi.service.ClientService;
import hw9.taxi.service.ClientServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sanya on 11.03.2015.
 */
@WebServlet("/RegisterClient")
public class ClientCreateServlet extends HttpServlet {

    private WebApplicationContext context;
    private ClientServiceImpl clientService;

    @Override
    public void init(){
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        clientService = (ClientServiceImpl) context.getBean("clientServiceImpl");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("action").equals("Register client")){
            request.getRequestDispatcher("registerClient.jsp").forward(request, response);
        }

        if (request.getParameter("action").equals("Cancel")){
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }
        if (request.getParameter("action").equals("Ok")){
            Client client = new Client(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("phone"), request.getParameter("address"));
            client.setSumma(0.0);
            clientService.create(client);
            request.setAttribute("successful", "Create client successful");
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }






    }
}
