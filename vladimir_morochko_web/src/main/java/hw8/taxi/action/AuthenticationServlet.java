package hw8.taxi.action;

import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.AuthenticationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vladimir on 03.03.2015.
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {

    AuthenticationService authenticationService = AuthenticationServiceImpl.authenticationService;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String authenticationResultMessage = null;
        boolean authenticationResult = false;
        try {
            authenticationResult = authenticationService.authenticate(login, password);
        } catch (AuthenticationException e) {
            // e.printStackTrace();
            authenticationResultMessage = e.getMessage();
        }
        if (authenticationResultMessage != null && authenticationResultMessage.equals("Password expired")) {
            request.setAttribute("defaultLogin", login);
            request.setAttribute("oldPassword", password);
            request.setAttribute("registerResultMessage", authenticationResultMessage);
            request.getRequestDispatcher("registerOperator.jsp").forward(request, response);
        }
        if (authenticationResult) {
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
            request.setAttribute("authenticationResultMessage", authenticationResultMessage);
            request.setAttribute("defaultLogin", login);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
