package hw8.taxi.action;

import hw8.taxi.domain.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by sanya on 04.03.2015.
 */
@WebServlet("/hw8Order")
public class OrderServlet extends HttpServlet{
    private static int porcia;

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Client> listClientsPorcia = new ArrayList<Client>();
        List<Client> listClients = new ArrayList<Client>();
        Client client1 = new Client("Alexandr", "Lapada", "0979469953", "Kiev", 400.0, null);
        Client client2 = new Client("Jon", "Jonson", "09799343535", "Kiev", 567.5, null);
        listClients.add(client1);
        listClients.add(client2);


        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Map<String, String[]> map = request.getParameterMap();


        System.out.println(request.getParameter("listOrderByPrice") + "********************");

        if (request.getParameter("releaseOrder") != null) {
            request.setAttribute("client1", client1.getFirstName());
            request.setAttribute("client2", client2.getFirstName());
            request.getRequestDispatcher("order.jsp").forward(request, response);
        }
            /*String dateOrder = map.get("dateOrder")[0];
            String client = map.get("clientOrder")[0];
            String price = map.get("priceOrder")[0];
            String addressClient = map.get("addressOrder")[0];
            String whereToGo = map.get("whereToGoOrder")[0];


            try {
                date = dateFormat.parse(dateOrder);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.err.println(dateFormat.format(date));
            System.out.println(dateOrder);

            System.out.println(request.getParameter("option"));
            System.out.println(price);
            System.out.println(addressClient);
            System.out.println(whereToGo);
            */

        if (request.getParameter("listOrderByPrice") != null) {
            request.setAttribute("list", listClients);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }

        if (request.getParameter("listOrderByPorcia") != null) {
            porcia = 0;
            for (int i = 0; i < 1; i++) {
                listClientsPorcia.add(listClients.get(i));
            }
            request.setAttribute("listPorcia", listClientsPorcia);
            porcia++;
            request.getRequestDispatcher("orders.jsp").forward(request, response);
        }

        if (request.getParameter("right") != null) {
            System.out.println(porcia);
            System.out.println(listClients.size());
            if (porcia * 1 <= listClients.size()) {
                for (int i = porcia; i < porcia*1; i++) {
                    listClientsPorcia.add(listClients.get(i));
                }
                request.setAttribute("listPorcia", listClientsPorcia);
                porcia++;
                request.getRequestDispatcher("orders.jsp").forward(request, response);
            }

        }
        if ((request.getParameter("left") != null)) {
            if (porcia > 0) {
                for (int i = porcia; i < porcia*1; i++) {
                    listClientsPorcia.add(listClients.get(i));
                }
                request.setAttribute("listPorcia", listClientsPorcia);
                porcia--;
                request.getRequestDispatcher("orders.jsp").forward(request, response);
            }
        }
    }

}
