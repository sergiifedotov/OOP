package hw9.taxi.controller;

import hw9.taxi.exception.AuthenticationException;
import hw9.taxi.service.AuthenticationService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by vladimir on 09.03.2015.
 */
@WebServlet("/authenticationServlet")
public class AuthenticationServlet extends HttpServlet {

    private AuthenticationService authenticationService;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        authenticationService = webApplicationContext.getBean("authenticationServiceImpl", AuthenticationService.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String authenticationResultMessage = null;
        boolean authenticationResult = false;
        try {
            authenticationResult = authenticationService.authenticate(login, password);
        } catch (AuthenticationException e) {
            //e.printStackTrace();
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
