package web.controller;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 *
 */
@WebServlet("/hello")
public class HelloSpring extends HttpServlet {
    private WebApplicationContext context;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (context != null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setMaxInactiveInterval(15);
            } else {
                Map<String,String[]> parametrs = request.getParameterMap();
                String login = parametrs.get("log")[0];
                String pass = parametrs.get("pass")[0];
                UserService userService = (UserService) context.getBean("authenticationServiceImp");
                boolean loginOK = false;
                String message = (String) context.getBean("str");
                loginOK = userService.authenticate(login, pass);
                if (loginOK) {
                    response.getWriter().print(message + " " + request.getParameter("log"));
                    HttpSession newsession = request.getSession();
                    newsession.setAttribute("login", login);
                    newsession.setAttribute("pass", pass);
                    request.getRequestDispatcher("loginOk.jsp").forward(request,response);

                } else {
                    response.getWriter().print("Error: Context not found");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
        } else {
            response.getWriter().print("Error: Context not found");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
