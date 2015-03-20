package hw9.taxi.controller;

import hw9.taxi.dao.ClientDaoImpl;
import hw9.taxi.domain.Client;
import hw9.taxi.service.ClientService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import web.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sanya on 11.03.2015.
 */
@WebServlet("/ClientShowGTSumm")
public class ClientShowSumServlet extends HttpServlet {

    private WebApplicationContext context;
    private ClientService clientService;

    @Override
    public void init(){
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        clientService = (ClientService) context.getBean("clientServiceImpl");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Client> listClientsGTSumm = null;
        if (request.getParameter("action").equals("Show all clients great than summa")){
            request.setAttribute("fieldEnterSumm","summa");
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }

        if (request.getParameter("action").equals("Confirm")){
            String summaStr = request.getParameter("summa");
            if (validTestSumma(summaStr)){
                Double summa = Double.valueOf(summaStr);
                listClientsGTSumm = (ArrayList<Client>) clientService.findAllGtSumm(summa);
                request.setAttribute("listClientsGTSumma",listClientsGTSumm);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else {
                request.setAttribute("fieldEnterSumm","summa");
                request.setAttribute("WrongTypeSumm","summaWrongType");
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }
        }

    }
    public boolean validTestSumma(String summa){
        if (summa != null) {
            Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*.).{1,}$");
            Matcher m = p.matcher(summa);
            return m.matches();
        }
        return false;
    }
}
