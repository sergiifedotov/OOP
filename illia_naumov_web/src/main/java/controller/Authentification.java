package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by illia_naumov on 01.03.2015.
 */
@WebServlet("/auth")
public class Authentification extends HttpServlet {
    protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parametrs = reg.getParameterMap();
        Map<String, String> map = new HashMap<String, String>();
        map.put("zina", "zina");
        map.put("vala", "vala");
        map.put("zerg", "zerg");
        String login = parametrs.get("login")[0];
        String password = parametrs.get("password")[0];
        if(map.containsKey(login) && map.get(login).equals(password)){
            reg.setAttribute("list", map);
            reg.getRequestDispatcher("good.jsp").forward(reg, resp);
        } else {
            reg.setAttribute("key", new String("Ошибка"));
            reg.getRequestDispatcher("index.jsp").forward(reg, resp);
    }
    }
}
