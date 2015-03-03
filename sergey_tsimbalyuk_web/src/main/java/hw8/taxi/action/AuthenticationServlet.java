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
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
@WebServlet("/auth")
public class AuthenticationServlet extends HttpServlet {
    private AuthenticationService authenticationService;
    private int loginTryCount;
    private Properties properties;

    public AuthenticationServlet(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void init() {
        authenticationService = new AuthenticationServiceImpl(loginTryCount);
        loginTryCount = 0;
        propertiesSetup();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            super.doGet(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("register") != null) {
            request.getRequestDispatcher("/reg").forward(request, response);
        } else {
            String login = request.getParameter("login");
            String pass = request.getParameter("password");
            try {
                if (authenticationService.authenticate(login, pass)) {
                    request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                } else {
                    request.setAttribute("wrong", "Login/Password is incorrect");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
        }

    }

    private void propertiesSetup() {
        try (InputStream inputStream = getServletContext().getResourceAsStream("conf.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLoginTryCount() {
        return loginTryCount;
    }

    public void setLoginTryCount(int loginTryCount) {
        this.loginTryCount = loginTryCount;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}