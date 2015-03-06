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
 * Created by warit on 01.03.2015.
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String[]> parametrs = req.getParameterMap();

        String name = parametrs.get("name")[0];
        String surname = parametrs.get("surname")[0];
        String phone = parametrs.get("phone")[0];
        String address = parametrs.get("address")[0];

        ClientService orderService = new ClientServiceImpl();
        boolean ok = false;
        try {
            ok = orderService.createClient(name, surname, phone, address);
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }

}
