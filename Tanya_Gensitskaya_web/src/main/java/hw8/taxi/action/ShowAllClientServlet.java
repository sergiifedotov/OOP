package hw8.taxi.action;

import hw8.taxi.dao.ClientDaoImpl;
import hw8.taxi.domain.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tanya on 06.03.2015.
 */
@WebServlet("/ShowAllClientServlet")
public class ShowAllClientServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientDaoImpl clientDaoImpl = new ClientDaoImpl();

        List<Client> list = clientDaoImpl.findAll();

            for (int i = 0; i <list.size(); i++) {
                Client client = list.get(i);
                response.getWriter().print(client + "\n");
            }


    }
}
