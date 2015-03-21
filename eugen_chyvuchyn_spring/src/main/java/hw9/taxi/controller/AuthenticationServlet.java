package hw9.taxi.controller;


import hw9.taxi.service.AuthenticationService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Chuvychin on 13.03.2015.
 */
@WebServlet ("/login")
public class AuthenticationServlet extends HttpServlet{
    private WebApplicationContext context;
    AuthenticationService authenticationService;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        authenticationService = context.getBean("AuthenticationServiceImpl",AuthenticationService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (context !=null){

        }
    }
}
