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
    private int count;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
        List<Client> list = clientDaoImpl.findAll();
//        List<Client> listTemp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        count=+5;
        if(count<list.size()) {
            for (int i = 0; i < count; i++) {
                Client client = list.get(i);
//                listTemp.add(client);
                sb.append(client).append("<br>");
            }
//            request.setAttribute("message", listTemp);
            request.setAttribute("message", sb.toString());
            request.getRequestDispatcher("/clients.jsp").forward(request, response);
        } else {
            count=0;
            request.setAttribute("message", "All client print");
            request.getRequestDispatcher("/clients.jsp").forward(request, response);
        }



    }
}
