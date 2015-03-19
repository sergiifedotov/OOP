package web.controller;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import web.dao.UserDao;
import web.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * UserDao: al1
 * Date: 9/8/13
 */

@WebServlet("/test")
public class HelloSpring extends HttpServlet {
    UserDao userdao;
    private WebApplicationContext context;

    @Override
    public void init() {
        Locale.setDefault(Locale.ENGLISH);
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        userdao = context.getBean(UserDao.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(context != null) {
            String message = (String) context.getBean("str");
            User usr = new User(request.getParameter("login"), request.getParameter("pass"));
            userdao.create(usr);
            response.getWriter().print(message + " " + request.getParameter("login"));
        } else  {
            response.getWriter().print("Error: Context not found!");
        }
        HttpSession session = request.getSession(true);
        if(session.isNew()) {
            response.getWriter().print(" New session ID: "+session.getId());
        } else {
            response.getWriter().print(session.getId());
            System.out.print("Old Session with ID: " + session.getId());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(" /test doPost answer for successful login/pwd check.");
    }

}