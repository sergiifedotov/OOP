package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by illia_naumov on 28.02.2015.
 */
@WebServlet("/serv")
public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parametrs = reg.getParameterMap();
        String value = parametrs.get("option")[0];
        resp.getWriter().print("Yo" + value);
    }

}
