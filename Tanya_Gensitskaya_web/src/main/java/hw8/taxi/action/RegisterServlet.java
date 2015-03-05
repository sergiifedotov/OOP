package hw8.taxi.action;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Tanya on 05.03.2015.
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        String login = map.get("login")[0];
        String idNumber = map.get("idNumber")[0];
        String password = map.get("password")[0];
        String confirmPassword = map.get("confirmPassword")[0];


        AuthenticationServiceImpl authenticationServiceImpl = new AuthenticationServiceImpl();


        try {
            if (authenticationServiceImpl.register(login, idNumber, password) &&
                    password.equals(confirmPassword) && authenticationServiceImpl.findLoginInBase(login)) {

                Operator operator = new Operator(login, idNumber, password, confirmPassword);
                authenticationServiceImpl.create(operator);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else {
                request.setAttribute("register", new String("Error!!!"));
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }


    }
}
