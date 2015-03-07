package web.controller;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import web.service.UserService;
import web.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (context != null) {
            String login = (String) request.getParameter("log");
            String pass = (String) request.getParameter("pass");
            UserService userService = (UserService) context.getBean("authenticationServiceImp");
            boolean loginOK = false;
            String message = (String) context.getBean("str");
            loginOK = userService.authenticate(login,pass);
            if (loginOK){
            response.getWriter().print(message + " " + request.getParameter("log"));}
            else{
                response.getWriter().print("Error: Context not found");
            }
        } else  {
            response.getWriter().print("Error: Context not found");
        }
    }
}
