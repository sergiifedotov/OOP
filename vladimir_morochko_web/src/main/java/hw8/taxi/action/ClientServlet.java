package hw8.taxi.action;

import hw8.taxi.domain.Client;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by vladimir on 03.03.2015.
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
    ClientService clientService = ClientServiceImpl.clientService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List list = null;
        if (action.equals("showClientsByPortion")) {
            list = clientService.showClientsByPortion(10);
            // TODO list size
        }
        if (action.equals("showClientsGtSum")) {
            list = clientService.showClientsGtSum(0);
            // TODO sum
        }
        if (action.equals("showClientsLastMonth")) {
            list = clientService.showClientsLastMonth();
        }
        request.getSession().setAttribute("clientList", list);
        request.getRequestDispatcher("clients.jsp").forward(request, response);
    }
}
