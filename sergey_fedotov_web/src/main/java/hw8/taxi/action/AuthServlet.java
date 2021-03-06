package hw8.taxi.action;

import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.AuthenticationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * this class for jon
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String[]> parametrs = req.getParameterMap();
        String login = parametrs.get("login")[0];
        String pass = parametrs.get("pass")[0];

        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        boolean loginOK = false;
        try {
            loginOK = authenticationService.authenticate(login,pass);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        if (loginOK){
            req.setAttribute("login", login);
            req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
        }else{
            req.setAttribute("errLogin",new String("error login!!!"));
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }

}
