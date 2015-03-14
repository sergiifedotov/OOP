package dreamteam.controller;

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
import java.util.Locale;

/**
 * Created by vladimir on 09.03.2015.
 */
@WebServlet("/clientShowPortionServlet")
public class ClientShowPortionServlet extends HttpServlet {

    private ClientService clientService;
    private Integer clientPortionSize;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        clientService = webApplicationContext.getBean("clientServiceImpl", ClientService.class);
        clientPortionSize = webApplicationContext.getBean("clientPortionSize", Integer.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(clientPortionSize);
        List list = clientService.getClientsByPortion(clientPortionSize);
        request.getSession().setAttribute("clientList", list);
        request.setAttribute("clientMessage", "Клиенты по " + clientPortionSize + " штук:");
        request.getRequestDispatcher("clients.jsp").forward(request, response);
    }
}
