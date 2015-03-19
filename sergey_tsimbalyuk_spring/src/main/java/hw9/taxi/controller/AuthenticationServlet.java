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
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */
@WebServlet("/auth")
public class AuthenticationServlet extends HttpServlet {
    private WebApplicationContext context;
    private AuthenticationService authenticationService;
//    private Map<String, String[]> map;

    @Override
    public void init() {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        authenticationService = context.getBean("AuthenticationServiceImpl", AuthenticationService.class);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}