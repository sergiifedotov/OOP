package hw9.taxi.controller;

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
@WebServlet("/clientShowSumServlet")
public class ClientShowSumServlet extends HttpServlet {

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
        String sumString = request.getParameter("clientMinSum");
        System.out.println(sumString);
        int sum = 0;
        if (sumString != null) {
            sum = Integer.parseInt(sumString);
        }
        List list = clientService.getClientsGtSum(sum);
        request.getSession().setAttribute("clientList", list);
        request.setAttribute("clientMinSum", sum);
        request.getRequestDispatcher("clients.jsp").forward(request, response);
    }
}
