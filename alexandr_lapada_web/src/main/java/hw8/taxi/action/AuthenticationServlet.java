package hw8.taxi.action;

import hw8.taxi.exception.AuthorizationException;
import hw8.taxi.service.AuthorizationService;
import hw8.taxi.service.AuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by sanya on 03.03.2015.
 */

@WebServlet("/hw8Auth")
public class AuthenticationServlet extends HttpServlet {

    private AuthorizationService authenticationService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        authenticationService = new AuthorizationServiceImpl();

        Map<String, String[]> map = request.getParameterMap();
        String login = map.get("login")[0];
        String password = map.get("password")[0];
        System.out.println(login);
        System.out.println(password);


        try {
            if(authenticationService.authenticate(login,password)){
                request.setAttribute("welcomeLogin",login);
                if (!authenticationService.changePass()) {
                    request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                } else{
                    request.setAttribute("changePass","Change password please");
                    request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                }
            }else {
                request.setAttribute("wrongUser","Wrong login or password try again");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } catch (AuthorizationException e) {
            request.setAttribute("ban","Больше трех неправильных вводов БАН!!");
            request.getRequestDispatcher("ban.jsp").forward(request,response);
            e.printStackTrace();
        }


    }


}
