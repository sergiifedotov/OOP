package hw9.taxi.controller;

import hw9.taxi.exception.ClientException;
import hw9.taxi.service.ClientService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 *
 */
@WebServlet("/clientCreate")
public class CreateClientServlet extends HttpServlet {

    private WebApplicationContext context;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (context != null) {

            Map<String, String[]> parametrs = req.getParameterMap();
            String name = parametrs.get("name")[0];
            String surname = parametrs.get("surname")[0];
            String phone = parametrs.get("phone")[0];
            String address = parametrs.get("address")[0];

            ClientService clientService = (ClientService) context.getBean("clientServiceImpl");
            String err = "";
            boolean createOK = false;
            try {
                createOK = clientService.createClient(name, surname, phone, address);
            } catch (ClientException e) {
                err = e.getMessage();
            }

            if (createOK) {
                resp.getWriter().print("Hello " + req.getParameter("log"));
                req.setAttribute("rezult", "create new client");
                req.getRequestDispatcher("registerClient.jsp").forward(req, resp);

            } else {
                req.setAttribute("rezult", err);
                req.getRequestDispatcher("registerClient.jsp").forward(req, resp);
            }

        } else {
            req.setAttribute("rezult", "error context!!!");
            req.getRequestDispatcher("registerClient.jsp").forward(req, resp);
        }

    }

}
