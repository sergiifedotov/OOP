package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 28.02.15
 */
@WebServlet("/serv")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String []> map = request.getParameterMap();
        String login = map.get("login")[0];

        String password = map.get("password")[0];
        if(login.equals("Tanya") && password.equals("Tanya")){
            request.getRequestDispatcher("good.jsp").forward(request, response);
        } else {
            request.setAttribute("hi", new String("Error"));
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

        response.getWriter().print("Hello " + login);
    }
}
