package hw9.taxi.controller;

import hw9.taxi.exception.AuthenticationException;
import hw9.taxi.service.AuthorizationService;
import hw9.taxi.service.AuthorizationServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sanya on 10.03.2015.
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    private WebApplicationContext context;
    private AuthorizationServiceImpl authorizationServiceService;

    @Override
    public void init(){
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        authorizationServiceService = (AuthorizationServiceImpl) context.getBean("authorizationServiceImpl");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("newLogin"));
        System.out.println(request.getParameter("newPassword"));
        System.out.println(request.getParameter("confPassword"));
        System.out.println(request.getParameter("identNumber"));

        try {
            if (authorizationServiceService.register(request.getParameter("newLogin"),request.getParameter("identNumber"),request.getParameter("newPassword"))
                    && confPass(request.getParameter("newPassword"),request.getParameter("confPassword"))) {
                request.setAttribute("login",request.getParameter("newLogin"));
                request.getRequestDispatcher("dashboard.jsp").forward(request,response);
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            if (!authorizationServiceService.validTestLogin(request.getParameter("newLogin"))) {
                request.setAttribute("wrongLogin", "Логин должен быть не меньше 4 символов без пробелов");
            }
            if (!authorizationServiceService.validTestPassword(request.getParameter("newPassword"))) {
                request.setAttribute("wrongPass", "Пароль должен состоять из цифр, маленьких и больших букв, длиной не меньше 8 символов без пробелов");
            }
            if (!authorizationServiceService.validTestLogin(request.getParameter("identNumber"))) {
                request.setAttribute("wrongId", "Идентификационный код должен состоять из цифр, длиной 10 символов без пробелов");
            }
            if (!confPass(request.getParameter("newPassword"),request.getParameter("confPassword"))) {
                request.setAttribute("wrongEqPass", "Пароли не совпадают");
            }
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

    }
    private boolean confPass(String pass, String confPass){
        if (pass.equals(confPass)){
            return true;
        }
        return false;
    }

}
