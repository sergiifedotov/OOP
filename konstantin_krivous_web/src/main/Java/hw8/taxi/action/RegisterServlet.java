package hw8.taxi.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Konstantin on 02.03.2015.
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameter = request.getParameterMap();
        String log = parameter.get("login")[0];
        String id = parameter.get("id")[0];
        String pas = parameter.get("password")[0];
        String rpas = parameter.get("repeatPassword")[0];

        if (log.equals("") || id.equals("") || pas.equals("") || rpas.equals("")){
           request.setAttribute("msg", "Не все данные введены. Проверьте и повторите попытку еще раз");

        }

        RequestDispatcher disp = request.getRequestDispatcher("register.jsp");
        disp.forward(request,response);
    }
}
