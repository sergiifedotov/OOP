package hw8.taxi.action;

import hw8.taxi.exception.AuthenticationException;
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
 * Created by illia_naumov on 10.03.2015.
 */

@WebServlet("/authorization")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parametrs = req.getParameterMap();
        String login = parametrs.get("login")[0];
        long id = Long.parseLong(parametrs.get("id")[0]);
        String password = parametrs.get("password")[0];
        String confirmPassword = parametrs.get("confirmPassword")[0];

        AuthorizationServiceImpl authorizationServiceImpl = new AuthorizationServiceImpl();

        if(password.equals(confirmPassword)){
            String validationMessage = authorizationServiceImpl.formValidation(login, id, password);
            if(validationMessage != null){
                req.setAttribute("answer", validationMessage);
                req.getRequestDispatcher("register.jsp").forward(req, resp);
                return;
            }
            try {
                if(authorizationServiceImpl.register(login, id, password)){
                    req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                } else {
                    req.setAttribute("answer", "Такой пользователь уже существует");
                    req.getRequestDispatcher("register.jsp").forward(req, resp);
                }
            } catch (AuthenticationException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("answer", "Логин и пароль не совпадают");
            try {
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
