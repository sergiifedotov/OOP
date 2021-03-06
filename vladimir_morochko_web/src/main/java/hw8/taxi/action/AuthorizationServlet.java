package hw8.taxi.action;

import hw8.taxi.exception.AuthorizationException;
import hw8.taxi.service.AuthorizationService;
import hw8.taxi.service.AuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vladimir on 03.03.2015.
 */
@WebServlet("/AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    AuthorizationService authorizationService = AuthorizationServiceImpl.authorizationService;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String accessId = request.getParameter("accessId");
        String password = request.getParameter("password");
        String oldPassword = request.getParameter("oldPassword");
        String passwordConfirm = request.getParameter("passwordConfirm");
        String registerResultMessage = "Operator created successfully";
        if (password.equals(oldPassword)) {
            registerResultMessage = "пароль должен отличаться от старого пароля";
        } else if (!password.equals(passwordConfirm)) {
            registerResultMessage = "пароль должен совпадать с подтверждением";
        } else {
            boolean registerResult = false;
            try {
                registerResult = authorizationService.register(login, accessId, password);
            } catch (AuthorizationException e) {
                // e.printStackTrace();
                registerResultMessage = e.getMessage();
                System.out.println(registerResultMessage);
            }
        }
        request.setAttribute("defaultLogin", login);
        request.setAttribute("defaultAccessId", accessId);
        request.setAttribute("registerResultMessage", registerResultMessage);
        request.getRequestDispatcher("registerOperator.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
