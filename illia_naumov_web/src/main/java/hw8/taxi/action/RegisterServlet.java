package hw8.taxi.action;

import hw8.taxi.exception.AuthorizationException;
import hw8.taxi.service.AuthorizationService;
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
 * Created by illia_naumov on 10.03.2015.
 */

@WebServlet("/authorization")
public class RegisterServlet extends HttpServlet {
    private AuthorizationService authorizationService;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        authorizationService = webApplicationContext.getBean("authorizationServiceImpl", AuthorizationService.class);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login =  req.getParameter("login");
        long id = Long.parseLong(req.getParameter("id"));
        String password =  req.getParameter("password");
        boolean authorizationSucceed = false;
        String authorizatonAnswer = null;

        try {
            authorizationService.register(login, id, password);
            authorizationSucceed = true;
        } catch (AuthorizationException e) {
            authorizatonAnswer = e.getMessage();
        }

        if(authorizationSucceed == true && authorizatonAnswer == null){
           req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
        } else {
            resp.getWriter().print(authorizatonAnswer);
        }


    }


}


