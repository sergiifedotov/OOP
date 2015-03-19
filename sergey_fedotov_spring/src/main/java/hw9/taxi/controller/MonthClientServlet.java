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
import java.util.List;

/**
 *
 */
@WebServlet("/clientShowMonthServlet2")
public class MonthClientServlet extends HttpServlet {

    private WebApplicationContext context;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (context != null) {

            ClientService clientService = (ClientService) context.getBean("clientServiceImpl");

                List<Client> list = clientService.getClientsLastMonth();

                req.setAttribute("list", list);
                req.getRequestDispatcher("clients.jsp").forward(req, resp);

        } else {
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
        }

    }


}
