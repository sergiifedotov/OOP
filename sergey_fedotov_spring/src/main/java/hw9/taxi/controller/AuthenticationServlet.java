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
 * Created by warit on 01.03.2015.
 */
@WebServlet("/auth")
public class AuthenticationServlet extends HttpServlet {
    private WebApplicationContext context;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (context != null) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.setMaxInactiveInterval(15);
            } else {
                Map<String,String[]> parametrs = req.getParameterMap();
                String login = parametrs.get("login")[0];
                String pass = parametrs.get("pass")[0];
                AuthenticationService authenticationService = (AuthenticationService) context.getBean("authenticationServiceImp");

                boolean loginOK = false;
                try {
                    loginOK = authenticationService.authenticate(login, pass);
                } catch (AuthenticationException e) {
                    e.printStackTrace();
                }

                if (loginOK) {
                    resp.getWriter().print("Hello " + req.getParameter("log"));
                    HttpSession newsession = req.getSession();
                    newsession.setAttribute("login", login);
                    newsession.setAttribute("pass", pass);
                    req.getRequestDispatcher("dashboard.jsp").forward(req,resp);

                } else {
                    req.setAttribute("errLogin", new String("error login or pass!!!"));
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            }
        } else {
            req.setAttribute("errLogin", new String("error login or pass!!!"));
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }


    }

}
