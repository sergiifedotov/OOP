package hw8.taxi.action;

import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sergey Tsimbalyuk
 * on 02.03.15
 */
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
    AuthorizationServiceImpl authorizationService;

    @Override
    public void init() {
        authorizationService = new AuthorizationServiceImpl();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login").trim();
        String password = request.getParameter("password").trim();
        String retryPassword = request.getParameter("retryPassword").trim();
        String id = request.getParameter("id").trim();
        if (password.equals(retryPassword)) {
            try {
                if (authorizationService.register(login, id, password)) {
                    request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                }
            } catch (AuthenticationException e) {
                e.printStackTrace();
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else {
            response.getWriter().print("Passwords don't match. Please try again.");
        }
    }
}