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
import java.util.Locale;

/**
 * Created by vladimir on 09.03.2015.
 */
@WebServlet("/clientCreateServlet")
public class ClientCreateServlet extends HttpServlet {

    private ClientService clientService;


    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        clientService = webApplicationContext.getBean("clientServiceImpl", ClientService.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String registerResultMessage = "Client created successfully";
        boolean registerResult = false;
        try {
            registerResult = clientService.createClient(name, surname, phone, address);
        } catch (ClientException e) {
            //e.printStackTrace();
            registerResultMessage = e.getMessage();
        }
        request.setAttribute("registerResultMessage", registerResultMessage);
        request.getRequestDispatcher("registerClient.jsp").forward(request, response);
    }
}
