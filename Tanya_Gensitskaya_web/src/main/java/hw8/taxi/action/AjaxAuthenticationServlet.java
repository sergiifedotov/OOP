package hw8.taxi.action;

import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Tanya on 17.03.2015.
 */
@WebServlet("/ajaxAuthenticationServlet")
public class AjaxAuthenticationServlet extends HttpServlet {
    private int count = 0;
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        String login = map.get("login")[0];
        String password = map.get("password")[0];

        AuthenticationServiceImpl authenticationServiceImpl = new AuthenticationServiceImpl();
        try {
            if(authenticationServiceImpl.authenticateAdmin(login, password)){
                response.getWriter().print("Admin loggin");
            } else if (authenticationServiceImpl.authenticate(login, password)) {
                response.getWriter().print("you are logged in!!!");
            } else {
                response.getWriter().print("you are not logged in!!!");
                count++;
                int freq = authenticationServiceImpl.frequency();
                if (count == freq) {
                    AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();
                    authenticationService.blocked(login);
                response.getWriter().print("</br>"+"you are blocked!!!");
                    count = 0;
                }
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}

