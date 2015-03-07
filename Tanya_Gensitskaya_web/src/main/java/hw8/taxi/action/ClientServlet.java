package hw8.taxi.action;

import hw8.taxi.dao.ClientDaoImpl;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import hw8.taxi.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Tanya on 05.03.2015.
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("registerClient.jsp").forward(request, response);
        Map<String, String[]> map = request.getParameterMap();
        String name = map.get("name")[0];
        String lastName = map.get("lastName")[0];
        String phone = map.get("phone")[0];
        String address = map.get("address")[0];
        String money = map.get("money")[0];
        String date = map.get("date")[0];

        ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
        ClientDaoImpl clientDaoImpl = new ClientDaoImpl();

        try {
            if(clientServiceImpl.createClient(name,  lastName, phone, address)){
                Client client = new Client(name, lastName, phone, address, money, date);
                clientDaoImpl.create(client);
                request.setAttribute("client", new String("Регистрация клиента успешна !!!"));
                request.getRequestDispatcher("registerClient.jsp").forward(request, response);
            } else {
                request.setAttribute("client", new String("Клиент не прошел регистрацию !!!"));
                request.getRequestDispatcher("registerClient.jsp").forward(request, response);
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
