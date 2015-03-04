package hw8.taxi.action;

import hw8.taxi.exception.ClientException;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by vladimir on 03.03.2015.
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    ClientService clientService = ClientServiceImpl.clientService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        String name = parameterMap.get("name")[0];
//        String surname = parameterMap.get("surname")[0];
//        String phone = parameterMap.get("phone")[0];
//        String address = parameterMap.get("address")[0];
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
}
