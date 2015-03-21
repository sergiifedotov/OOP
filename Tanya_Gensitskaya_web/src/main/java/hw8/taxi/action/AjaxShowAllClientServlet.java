package hw8.taxi.action;

import hw8.taxi.dao.ClientDaoImpl;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.CountShowAllClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tanya on 18.03.2015.
 */
@WebServlet("/ajaxShowAllClientServlet")
public class AjaxShowAllClientServlet extends HttpServlet {
    CountShowAllClient countShowAllClient = new CountShowAllClient();
//    countShowAllClient.getPorshionTop()
//    countShowAllClient.getPorshionButtom()
    ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
    List<Client> list = clientDaoImpl.findAll();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
            for (int i = countShowAllClient.getPorshionTop(); i < countShowAllClient.getPorshionButtom(); i++) {
                Client client = list.get(i);
                    Long idL = client.getId();
                    String idS = idL+"";

                    String name = client.getName();
                    String lastName = client.getLastName();
                    String money = client.getMoney();
                    String phone = client.getPhone();
                    String adress = client.getAddress();
                    String date = client.getDate();

                    sb.append(idS).append(" +");
                    sb.append(name).append(" +");
                    sb.append(lastName).append(" +");
                    sb.append(money).append(" +");
                    sb.append(phone).append(" +");
                    sb.append(adress).append(" +");
                    sb.append(date).append(" +");
            }
        countShowAllClient.setPorshionTop(countShowAllClient.getPorshionTop()+5);
        countShowAllClient.setPorshionButtom(countShowAllClient.getPorshionButtom()+5);
        response.getWriter().print(sb);
    }
}
