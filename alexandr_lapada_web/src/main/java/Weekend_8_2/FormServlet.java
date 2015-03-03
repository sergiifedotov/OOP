package Weekend_8_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanya on 01.03.2015.
 */

@WebServlet("/formServlet")
public class FormServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> mapUsers = new HashMap<String, String>();
        mapUsers.put("zagebenge","123456");
        mapUsers.put("Alex","alex");
        mapUsers.put("login","password");
        mapUsers.put("AA","123456");
        mapUsers.put("Petya","12EE12");

        Map<String, String[]> map = request.getParameterMap();
        String login = map.get("login")[0];
        String password = map.get("password")[0];

        if(mapUsers.containsKey(login) && mapUsers.get(login).equals(password)){
            request.getRequestDispatcher("dashboard.jsp").forward(request,response);
        } else {
            request.setAttribute("wrongUser","Wrong login or passwort try again");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

}
