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
 * Created by warit on 01.03.2015.
 */
@WebServlet("/auth")
public class RegisterServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String[]> parametrs = req.getParameterMap();
        String login = parametrs.get("login")[0];
        String id = parametrs.get("id")[0];
        String pass = parametrs.get("pass")[0];
        String passConfirmation = parametrs.get("passConfirmation")[0];

        if (!pass.equals(passConfirmation)){
            req.setAttribute("errLogin",new String("error login or pass!!!"));
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }

        AuthorizationService authorizationService = new AuthorizationServiceImpl();
        boolean regOK = false;
        try {
            regOK = authorizationService.register(login,id,pass);
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }

        if (regOK){
            req.setAttribute("login", login);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else{
            req.setAttribute("errLogin",new String("error login or pass!!!"));
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }

    }

}
