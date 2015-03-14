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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanya on 11.03.2015.
 */
@WebServlet("/ShowPortionClient")
public class ClientShowPortionServlet extends HttpServlet {

    private static int a;
    private final int porcia = 10;
    private WebApplicationContext context;
    private ClientService clientService;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        clientService = (ClientService) context.getBean("clientServiceImpl");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("action"));
        ArrayList<Client> list = (ArrayList<Client>) clientService.findAll();

        if (request.getParameter("action").equals("View all clients by portion 10")
                || request.getParameter("action").equals("right")
                || request.getParameter("action").equals("left")) {

            ArrayList<Client> listPorcia = null;

            if (request.getParameter("action").equals("View all clients by portion 10")) {
                listPorcia = (ArrayList<Client>) clientService.findAllByPortion(a * porcia, porcia);
            }

            if (request.getParameter("action").equals("right")) {
                if (a * porcia < list.size()) {
                    listPorcia = (ArrayList<Client>) clientService.findAllByPortion(a * porcia, porcia);
                    a++;
                } else {
                    a = 0;
                    listPorcia = (ArrayList<Client>) clientService.findAllByPortion(a * porcia, porcia);
                    a++;
                }
            }

            if (request.getParameter("action").equals("left")) {
                if (a == 0) {
                    listPorcia = (ArrayList<Client>) clientService.findAllByPortion(a * porcia, porcia);
                    a = list.size() / porcia;
                    a--;
                } else {

                    listPorcia = (ArrayList<Client>) clientService.findAllByPortion(a * porcia, porcia);
                    a--;
                }

            }
            System.out.println(a);
            //request.setAttribute("login", list);
            request.setAttribute("viewAllClientsByPorcia", listPorcia);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }

    }
}
