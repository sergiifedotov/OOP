package hw8.action;

import hw8.exception.AuthenticationException;
import hw8.service.AuthenticationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Tanya on 04.03.2015.
 */
@WebServlet("/authenticationServlet")
public class AuthenticationServlet extends HttpServlet {
    private int count = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Map<String, String []> map = request.getParameterMap();
        String login = map.get("login")[0];
        String password = map.get("password")[0];

        AuthenticationServiceImpl authenticationServiceImpl = new AuthenticationServiceImpl();

        try {
            if(authenticationServiceImpl.authenticate(login, password)){
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            } else {
                count++;
                int freq = authenticationServiceImpl.frequency();
                if (count == freq){
                    authenticationServiceImpl.blocked(login);
                    request.setAttribute("hi", new String("Вас заблокированно!!!"));
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    count =0;
                }
                request.setAttribute("hi", new String("Error"));
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }


        response.getWriter().print("Hello " + login);
    }



}
