package hw9.taxi.controller;

import hw9.taxi.dao.ClientDao;
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
@WebServlet("/orderCreateServlet")
public class OrderCreateServlet extends HttpServlet {

    private ClientDao clientDao;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        clientDao = webApplicationContext.getBean("clientDaoImpl", ClientDao.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List list = clientDao.findAll();
        request.getSession().setAttribute("clientList", list);
        request.getSession().setAttribute("defaultClientId", 1L);
        request.setAttribute("defaultAmount", 0);
        request.setAttribute("orderMessage", "createOrder");
        request.getRequestDispatcher("order.jsp").forward(request, response);
    }
}
