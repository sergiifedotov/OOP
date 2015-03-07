package hw8.taxi.action;

import hw8.taxi.exception.ClientException;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.ClientServiceImpl;
import hw8.taxi.service.PropertiesService;
import hw8.taxi.service.PropertiesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by vladimir on 03.03.2015.
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
    ClientService clientService = ClientServiceImpl.clientService;
    PropertiesService propertiesService = PropertiesServiceImpl.propertiesService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List list = null;
        if (action.equals("registerClient")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            boolean registerResult = false;
            try {
                registerResult = clientService.createClient(name, surname, phone, address);
            } catch (ClientException e) {
                e.printStackTrace();
            }
            String registerResultMessage = registerResult ? "Client created successfully" : "Error!";
            request.setAttribute("registerResultMessage", registerResultMessage);
            request.getRequestDispatcher("registerClient.jsp").forward(request, response);
        }
        if (action.equals("showClientsByPortion")) {
            int clientPortionSize = propertiesService.getClientPortionSize();
            list = clientService.showClientsByPortion(clientPortionSize);
            request.setAttribute("clientMinSum", 0);
            request.getSession().setAttribute("clientList", list);
            request.getRequestDispatcher("clients.jsp").forward(request, response);
        }
        if (action.equals("showClientsGtSum")) {
            int sum = Integer.parseInt(request.getParameter("clientMinSum"));
            list = clientService.showClientsGtSum(sum);
            request.setAttribute("clientMinSum", sum);
            request.getSession().setAttribute("clientList", list);
            request.getRequestDispatcher("clients.jsp").forward(request, response);
        }
        if (action.equals("showClientsLastMonth")) {
            list = clientService.showClientsLastMonth();
            request.getSession().setAttribute("clientList", list);
            request.getRequestDispatcher("clients.jsp").forward(request, response);
        }
    }
}
