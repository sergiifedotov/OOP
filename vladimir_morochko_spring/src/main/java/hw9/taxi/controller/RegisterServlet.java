package hw9.taxi.controller;

import hw9.taxi.exception.AuthenticationException;
import hw9.taxi.service.AuthenticationService;
import hw9.taxi.service.AuthorizationService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by vladimir on 09.03.2015.
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    private AuthorizationService authorizationService;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        authorizationService = webApplicationContext.getBean("authorizationServiceImpl", AuthorizationService.class);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String accessId = request.getParameter("accessId");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        String registerResultMessage = null;
        if (!password.equals(passwordConfirm)) {
            registerResultMessage = "пароль должен совпадать с подтверждением";
        } else {
            boolean registerResult = false;
            try {
                registerResult = authorizationService.register(login, accessId, password);
            } catch (AuthenticationException e) {
                // e.printStackTrace();
                registerResultMessage = e.getMessage();
                System.out.println(registerResultMessage);
            }
            if (registerResult) {
                registerResultMessage = "Operator created successfully";
                request.setAttribute("authenticationResultMessage", registerResultMessage);
                request.setAttribute("defaultLogin", login);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        request.setAttribute("defaultLogin", login);
        request.setAttribute("defaultAccessId", accessId);
        request.setAttribute("registerResultMessage", registerResultMessage);
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
