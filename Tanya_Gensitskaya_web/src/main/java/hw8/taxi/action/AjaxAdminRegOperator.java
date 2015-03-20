package hw8.taxi.action;

import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationServiceImpl;
import hw8.taxi.service.AuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Tanya on 19.03.2015.
 */
@WebServlet("/ajaxAdminRegOperator")
public class AjaxAdminRegOperator extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        String login = map.get("login")[0];
        String idNumber = map.get("idNumber")[0];
        String password = map.get("password")[0];
        String confirmPassword = map.get("confirmPassword")[0];


        AuthenticationServiceImpl authenticationServiceImpl = new AuthenticationServiceImpl();
        AuthorizationServiceImpl authorizationServiceImpl = new AuthorizationServiceImpl();

        try {
            if (authorizationServiceImpl.register(login, idNumber, password) &&
                    password.equals(confirmPassword) && authenticationServiceImpl.findLoginInBase(login)) {

                Operator operator = new Operator(login, idNumber, password, confirmPassword);
                authenticationServiceImpl.create(operator);
                response.getWriter().print("registration operator successful");
            } else {
                response.getWriter().print("registration operator not successful");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }


    }
}