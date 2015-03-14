package hw8.taxi.action;

import hw8.taxi.service.AuthenticationServiceImpl;
import hw8.taxi.service.PropertiesValueGetter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by illia_naumov on 06.03.2015.
 */
@WebServlet("/authenticator")
public class AuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parametrs = req.getParameterMap();
        String login = parametrs.get("login")[0];
        String password = parametrs.get("password")[0];

        AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();

        if (authenticationService.authenticate(login, password)) {
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

}
