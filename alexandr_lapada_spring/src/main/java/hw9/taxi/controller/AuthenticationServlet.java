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
import java.util.Map;

/**
 * Created by sanya on 10.03.2015.
 */
@WebServlet("/Authentication")
public class AuthenticationServlet extends HttpServlet {

    private WebApplicationContext context;
    private AuthenticationService authenticationServiceService;

    @Override
    public void init(){
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        authenticationServiceService = (AuthenticationService) context.getBean("authenticationServiceImpl");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (authenticationServiceService.authenticate(request.getParameter("login"), request.getParameter("pass"))){
                request.getRequestDispatcher("dashboard.jsp").forward(request,response);
            }else{
                request.setAttribute("wrongAuth","Wrong login or password.");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } catch (AuthenticationException e) {
            request.setAttribute("wrongAuth","3");
            request.getRequestDispatcher("index.jsp").forward(request,response);
            e.printStackTrace();
        }
    }
}
