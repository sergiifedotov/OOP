package hw9.taxi.controller;

import hw9.taxi.exception.AuthenticationException;
import hw9.taxi.service.AuthorizationService;
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
 * Created by warit on 01.03.2015.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private WebApplicationContext context;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (context != null) {
            HttpSession session = req.getSession(false);

            Map<String, String[]> parametrs = req.getParameterMap();
            String login = parametrs.get("login")[0];
            String id = parametrs.get("id")[0];
            String pass = parametrs.get("pass")[0];
            String passConfirmation = parametrs.get("passConfirmation")[0];

            if (!pass.equals(passConfirmation)) {
                req.setAttribute("errLogin", new String("error pass!!!"));
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }

            AuthorizationService authorizationService = (AuthorizationService) context.getBean("authorizationServiceImpl");
            String err = "";
            boolean regOK = false;
            try {
                regOK = authorizationService.register(login, id, pass);
            } catch (AuthenticationException e) {
                err = e.getMessage();
            }

            if (regOK) {
                resp.getWriter().print("Hello " + req.getParameter("log"));
                HttpSession newsession = req.getSession();
                newsession.setAttribute("login", login);
                newsession.setAttribute("pass", pass);
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

            } else {
                req.setAttribute("errLogin", err);
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }

        } else {
            req.setAttribute("errLogin", new String("error context!!!"));
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }

    }

}
