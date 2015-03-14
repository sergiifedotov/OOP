package hw9.taxi.controller;

import hw9.taxi.domain.Client;
import hw9.taxi.service.ClientService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by sanya on 11.03.2015.
 */
@WebServlet("/ShowClientsByMonth")
public class ClientShowMonthServlet extends HttpServlet {

    private WebApplicationContext context;
    private ClientService clientService;

    @Override
    public void init(){
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        clientService = (ClientService) context.getBean("clientServiceImpl");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Client> listClientsByMonth;
        if (request.getParameter("action").equals("Show all clients last month")) {
            listClientsByMonth = (ArrayList<Client>) clientService.findAllLastMonth();
            request.setAttribute("listClientByMonth", listClientsByMonth);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);

        }
    }
}
