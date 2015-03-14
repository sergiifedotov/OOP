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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
@WebServlet("/auth")
public class AuthenticationServlet extends HttpServlet {
    private WebApplicationContext context;
    private AuthenticationService authenticationService;
    private Map<String, String[]> map;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        authenticationService = context.getBean("auth", AuthenticationService.class);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            checkAuthentication(request, response);
        }
        request.setAttribute("list", authenticationService.findAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    public void checkAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String login = null;
        if (context != null) {
            map = request.getParameterMap();
            if (map.containsKey("login") && map.containsKey("pass")) {
                login = map.get("login")[0];
                String password = map.get("pass")[0];
                try {
                    authenticationService.authenticate(login, password);
                } catch (AuthenticationException e) {
                    e.printStackTrace();
                    request.setAttribute("error", e.getMessage());
                    request.setAttribute("login", login);
                    try {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } catch (Exception e1) {
                        e.printStackTrace();
                    }
                }
            }
        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(20);
        session.setAttribute("login", login);
    }

}